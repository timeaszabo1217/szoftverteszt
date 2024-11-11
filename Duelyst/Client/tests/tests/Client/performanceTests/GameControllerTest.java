package tests.Client.performanceTests;

import controller.Client;
import controller.GameController;
import javafx.application.Platform;
import models.account.Account;
import models.comperessedData.CompressedGame;
import models.comperessedData.CompressedPlayer;
import models.comperessedData.CompressedGameMap;
import models.game.GameType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameControllerTest {

    private GameController gameController;
    private CompressedGame mockGame;
    private MockedStatic<Platform> mockedPlatform;  // Declare as class field

    @BeforeEach
    public void setUp() {
        // Mock the JavaFX Platform.runLater to avoid JavaFX Toolkit initialization errors
        mockedPlatform = Mockito.mockStatic(Platform.class);
        mockedPlatform.when(() -> Platform.runLater(Mockito.any(Runnable.class))).thenAnswer((Answer<Void>) invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        });

        // Obtain the singleton instance of GameController
        gameController = GameController.getInstance();

        // Mock the dependencies
        CompressedPlayer player1 = mock(CompressedPlayer.class);
        CompressedPlayer player2 = mock(CompressedPlayer.class);
        CompressedGameMap gameMap = mock(CompressedGameMap.class);
        GameType gameType = mock(GameType.class);

        // Configure the mocked players to return specific usernames
        when(player1.getUserName()).thenReturn("testUser1");
        when(player2.getUserName()).thenReturn("testUser2");

        // Create a mocked CompressedGame instance with mocked dependencies
        mockGame = new CompressedGame(player1, player2, gameMap, 1, gameType);
    }

    @AfterEach
    public void tearDown() {
        // Close the mocked Platform after each test to avoid conflicts
        if (mockedPlatform != null) {
            mockedPlatform.close();
        }
    }

    @Test
    public void testSingletonInstance() {
        GameController instance1 = GameController.getInstance();
        GameController instance2 = GameController.getInstance();
        assertSame(instance1, instance2, "getInstance() should return the same instance each time");
    }

    @Test
    public void testCalculateAvailableActionsPerformance() {
        // Mock the Client and Account classes
        Client mockClient = mock(Client.class);
        Account mockAccount = mock(Account.class);
        when(mockClient.getAccount()).thenReturn(mockAccount);
        when(mockAccount.getUsername()).thenReturn("testUser1"); // Username set to match player1's username

        // Inject the mock Client into the GameController
        Client.setInstance(mockClient);

        // A teszt végrehajtása a mockolt példánnyal
        gameController.setCurrentGame(mockGame);

        long startTime = System.nanoTime();
        gameController.calculateAvailableActions();
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time for calculateAvailableActions: " + executionTime + " ms");

        assertTrue(executionTime < 500, "calculateAvailableActions took too long to execute");
    }

    @Test
    public void testSetCurrentGame() {
        gameController.setCurrentGame(mockGame);

        assertEquals(mockGame, gameController.getCurrentGame(), "setCurrentGame should correctly set the current game");
    }
}
