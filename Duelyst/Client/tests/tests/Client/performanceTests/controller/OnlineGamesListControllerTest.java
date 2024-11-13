package tests.Client.performanceTests.controller;

import controller.Client;
import controller.OnlineGamesListController;
import models.message.MessageType;
import models.message.OnlineGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

public class OnlineGamesListControllerTest {
    private OnlineGamesListController onlineGamesListController;
    private Client mockClient;

    @BeforeEach
    public void setUp() {
        onlineGamesListController = OnlineGamesListController.getInstance();
        mockClient = Mockito.mock(Client.class);
        Client.setInstance(mockClient);
    }

    @Test
    public void testRequestShowGame() {
        OnlineGame mockGame = Mockito.mock(OnlineGame.class);

        onlineGamesListController.requestShowGame(mockGame);

        verify(mockClient).addToSendingMessagesAndSend(argThat(message ->
                message.getMessageType() == MessageType.ONLINE_GAME_SHOW_REQUEST &&
                        message.getOnlineGames() != null &&
                        Arrays.asList(message.getOnlineGames()).contains(mockGame)
        ));
    }

    @Test
    public void testSetOnlineGames() throws Exception {
        OnlineGame[] mockGames = {Mockito.mock(OnlineGame.class), Mockito.mock(OnlineGame.class)};

        Method setOnlineGamesMethod = OnlineGamesListController.class.getDeclaredMethod("setOnlineGames", OnlineGame[].class);
        setOnlineGamesMethod.setAccessible(true);
        setOnlineGamesMethod.invoke(onlineGamesListController, (Object) mockGames);

        assertArrayEquals(mockGames, onlineGamesListController.getOnlineGames());
    }
}
