package tests.Client.performanceTests.controller;

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
    private MockedStatic<Platform> mockedPlatform;

    @BeforeEach
    public void setUp() {
        mockedPlatform = Mockito.mockStatic(Platform.class);
        mockedPlatform.when(() -> Platform.runLater(Mockito.any(Runnable.class))).thenAnswer((Answer<Void>) invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        });

        gameController = GameController.getInstance();

        CompressedPlayer player1 = mock(CompressedPlayer.class);
        CompressedPlayer player2 = mock(CompressedPlayer.class);
        CompressedGameMap gameMap = mock(CompressedGameMap.class);
        GameType gameType = mock(GameType.class);

        when(player1.getUserName()).thenReturn("testUser1");
        when(player2.getUserName()).thenReturn("testUser2");

        mockGame = new CompressedGame(player1, player2, gameMap, 1, gameType);
    }

    @AfterEach
    public void tearDown() {
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
        Client mockClient = mock(Client.class);
        Account mockAccount = mock(Account.class);
        when(mockClient.getAccount()).thenReturn(mockAccount);
        when(mockAccount.getUsername()).thenReturn("testUser1");

        Client.setInstance(mockClient);

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
