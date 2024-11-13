package tests.Client.performanceTests.controller;

import controller.Client;
import controller.WaitingController;
import models.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class WaitingControllerTest {
    private WaitingController waitingController;
    private Client mockClient;

    @BeforeEach
    public void setUp() {
        waitingController = WaitingController.getInstance();
        mockClient = Mockito.mock(Client.class);

        Client.setInstance(mockClient);
    }

    @Test
    public void testCancel() {
        waitingController.cancel();

        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }
}
