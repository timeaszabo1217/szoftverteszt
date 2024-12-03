package tests.Client.performanceTests.model.message;

import models.comperessedData.CompressedGame;
import models.message.GameCopyMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class GameCopyMessageTest {
    private CompressedGame compressedGame;
    private GameCopyMessage gameCopyMessage;

    @BeforeEach
    void setup() {
        compressedGame = mock(CompressedGame.class);
        gameCopyMessage = mock(GameCopyMessage.class);
    }

    @Test
    void testGetCompressedGame() {
        assertNull(gameCopyMessage.getCompressedGame());
    }
}
