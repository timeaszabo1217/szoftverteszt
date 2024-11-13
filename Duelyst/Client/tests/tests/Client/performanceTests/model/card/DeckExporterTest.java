package tests.Client.performanceTests.model.card;

import models.card.Deck;
import models.card.DeckExporter;
import models.card.ExportedDeck;
import models.JsonConverter;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DeckExporterTest {
    private static final String DIRECTORY_NAME = "exported_decks";
    private Deck mockDeck;
    private DeckExporter deckExporter;

    @BeforeEach
    void setUp() {
        mockDeck = Mockito.mock(Deck.class);
        when(mockDeck.getName()).thenReturn("TestDeck");
        deckExporter = new DeckExporter(mockDeck);
    }

    @AfterEach
    void cleanUp() throws IOException {
        File directory = new File(DIRECTORY_NAME);
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                file.delete();
            }
            directory.delete();
        }
    }

    @Test
    void testExport_CreatesDirectoryIfNotExist() {
        File directory = new File(DIRECTORY_NAME);
        directory.delete();

        deckExporter.export();

        Assertions.assertTrue(directory.exists(), "A 'exported_decks' könyvtárnak létre kell jönnie az export során.");
    }

    @Test
    void testExport_CreatesFileWithCorrectContent() throws IOException {
        ExportedDeck realExportedDeck = new ExportedDeck(mockDeck);
        String expectedJson = JsonConverter.toJson(realExportedDeck);

        deckExporter.export();

        File exportedFile = new File(DIRECTORY_NAME + "/TestDeck.deck.json");
        Assertions.assertTrue(exportedFile.exists(), "The exported file should exist.");

        String fileContent = Files.readString(exportedFile.toPath());
        assertEquals(expectedJson, fileContent, "The file content should match the expected JSON.");
    }


    @Test
    void testExport_FileNameUniqueness() {
        deckExporter.export();
        deckExporter.export();

        File file1 = new File(DIRECTORY_NAME + "/TestDeck.deck.json");
        File file2 = new File(DIRECTORY_NAME + "/TestDeck2.deck.json");

        Assertions.assertTrue(file1.exists(), "Az első exportált fájlnak léteznie kell.");
        Assertions.assertTrue(file2.exists(), "A második exportált fájlnak egyedi névvel kell létrejönnie.");
    }
}
