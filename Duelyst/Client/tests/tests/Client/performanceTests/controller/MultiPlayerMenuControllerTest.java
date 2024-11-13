package tests.Client.performanceTests.controller;

import controller.Client;
import controller.MultiPlayerMenuController;
import models.Constants;
import models.game.GameType;
import models.message.Message;
import models.message.MessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MultiPlayerMenuControllerTest {

    private MultiPlayerMenuController multiPlayerMenuController;
    private Client mockClient;

    @BeforeEach
    public void setUp() {
        multiPlayerMenuController = MultiPlayerMenuController.getInstance();
        mockClient = Mockito.mock(Client.class);
        Client.setInstance(mockClient);
    }

    @Test
    public void testStartGameWithValidData() {
        GameType gameType = GameType.SOME_FLAG;
        int numberOfFlags = 3;
        String opponent = "ValidOpponent";

        multiPlayerMenuController.startGame(gameType, numberOfFlags, opponent);

        ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(Message.class);
        verify(mockClient).addToSendingMessagesAndSend(messageCaptor.capture());

        Message sentMessage = messageCaptor.getValue();
        assertEquals(MessageType.MULTIPLAYER_GAME_REQUEST, sentMessage.getMessageType());
        assertEquals(Constants.SERVER_NAME, sentMessage.getReceiver());
        assertEquals(gameType, sentMessage.getNewGameFields().getGameType());
        assertEquals(opponent, sentMessage.getNewGameFields().getOpponentUsername());
    }


    // TODO: again, the JavaFX is the problem..
    @Test
    public void testStartGameWithInvalidOpponent() {
        String invalidOpponent = "A";
        GameType gameType = GameType.SOME_FLAG;
        int numberOfFlags = 2;

        multiPlayerMenuController.startGame(gameType, numberOfFlags, invalidOpponent);

        verify(mockClient.getCurrentShow()).showError("invalid opponent");
    }
}
