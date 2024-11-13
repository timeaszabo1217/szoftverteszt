package Client.controller;

import controller.MainMenuController;
import controller.Client;
import models.account.Account;
import models.account.AccountType;
import models.message.ChatMessage;
import models.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private Client mockClient;
    private Account mockAccount;

    @BeforeEach
    public void setUp() {
        mainMenuController = MainMenuController.getInstance();
        mockClient = Mockito.mock(Client.class);
        mockAccount = Mockito.mock(Account.class);

        when(mockClient.getAccount()).thenReturn(mockAccount);

        when(mockAccount.getUsername()).thenReturn("testUser");

        Client.setInstance(mockClient);
    }


    @Test
    public void testLogout() {
        mainMenuController.logout();
        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testRequestLeaderboard() {
        mainMenuController.requestLeaderboard();
        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testSendChatMessage() {
        String messageText = "Hello World!";
        mainMenuController.sendChatMessage(messageText);
        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    // TODO: Doesn't work, because the JavaFX hasn't started. But if we do start it,
    //  the other tests won't work.
    @Test
    public void testAddChatMessage() {
        ChatMessage mockChatMessage = Mockito.mock(ChatMessage.class);
        mainMenuController.addChatMessage(mockChatMessage);
    }

    @Test
    public void testChangeAccountTypeRequest() {
        String username = "testUser";
        AccountType newType = AccountType.ADMIN;
        mainMenuController.changeAccountTypeRequest(username, newType);
        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testAcceptCustomCard() {
        String cardName = "CustomCard1";
        mainMenuController.acceptCustomCard(cardName);
        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testRejectCustomCard() {
        String cardName = "CustomCard2";
        mainMenuController.rejectCustomCard(cardName);
        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }
}
