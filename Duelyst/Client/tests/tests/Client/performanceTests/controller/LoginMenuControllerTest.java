package tests.Client.performanceTests.controller;

import controller.Client;
import controller.LoginMenuController;
import models.Constants;
import models.message.Message;
import models.message.MessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



/**
 * TODO: This test class is not working at all, needs some work love.
 * */


public class LoginMenuControllerTest {

    private LoginMenuController loginMenuController;
    private Client mockClient;

    @BeforeEach
    public void setUp() {
        loginMenuController = LoginMenuController.getInstance();
        mockClient = Mockito.mock(Client.class);
        Client.setInstance(mockClient);
    }

    @Test
    public void testRegisterWithValidCredentials() {
        String userName = "ValidUser";
        String password = "ValidPass123";

        loginMenuController.register(userName, password);

        ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(Message.class);
        verify(mockClient).addToSendingMessagesAndSend(messageCaptor.capture());

        Message sentMessage = messageCaptor.getValue();
        assertEquals(MessageType.REGISTER, sentMessage.getMessageType());
        assertEquals(Constants.SERVER_NAME, sentMessage.getReceiver());
        assertEquals(userName, sentMessage.getAccountCopyMessage().getAccount().getUsername());
    }

    // TODO: again, JavaFX...
    @Test
    public void testRegisterWithInvalidUsername() {
        String invalidUserName = "A"; // Too short
        String password = "ValidPass123";

        loginMenuController.register(invalidUserName, password);

        verify(mockClient.getCurrentShow()).showError("Username is too short!(at least 3 characters)");
    }

    // TODO: again, JavaFX...
    @Test
    public void testRegisterWithInvalidPassword() {
        String userName = "ValidUser";
        String invalidPassword = "123"; // Too short

        loginMenuController.register(userName, invalidPassword);

        verify(mockClient.getCurrentShow()).showError("Password is too short!(at least 5 characters)");
    }

    @Test
    public void testLoginWithValidCredentials() {
        String userName = "ValidUser";
        String password = "ValidPass123";

        loginMenuController.login(userName, password);

        ArgumentCaptor<Message> messageCaptor = ArgumentCaptor.forClass(Message.class);
        verify(mockClient).addToSendingMessagesAndSend(messageCaptor.capture());

        Message sentMessage = messageCaptor.getValue();
        assertEquals(MessageType.LOG_IN, sentMessage.getMessageType());
        assertEquals(Constants.SERVER_NAME, sentMessage.getReceiver());
        assertEquals(userName, sentMessage.getAccountCopyMessage().getAccount().getUsername());
    }

    // TODO: again, JavaFX...
    @Test
    public void testLoginWithInvalidUsername() {
        String invalidUserName = "A"; // Too short
        String password = "ValidPass123";

        loginMenuController.login(invalidUserName, password);

        verify(mockClient.getCurrentShow()).showError("Username is too short!(at least 3 characters)");
    }

    // TODO: again, JavaFX...
    @Test
    public void testLoginWithInvalidPassword() {
        String userName = "ValidUser";
        String invalidPassword = "123"; // Too short

        loginMenuController.login(userName, invalidPassword);

        verify(mockClient.getCurrentShow()).showError("Password is too short!(at least 5 characters)");
    }
}
