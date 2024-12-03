package tests.Client.performanceTests.model.message;

import models.Constants;
import models.message.ChatMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatMessageTest {

    private ChatMessage chatMessage;
    private String senderUsername;
    private String receiverUsername;
    private String text;

    @BeforeEach
    void setup() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        senderUsername = "Ez";
        receiverUsername = "Az";
        text = "Udvozlegy";

        Constructor<ChatMessage> constructor = ChatMessage.class.getDeclaredConstructor(String.class, String.class, String.class);
        constructor.setAccessible(true);
        chatMessage = constructor.newInstance(senderUsername, receiverUsername, text);
    }

    @Test
    void testGetSenderUsername() {
        var result = chatMessage.getSenderUsername();
        assertEquals(senderUsername, result);
    }

    @Test
    void testGetReceiverUsername() {
        var result = chatMessage.getReceiverUsername();
        assertEquals(receiverUsername, result);
    }

    @Test
    void testGetText() {
        var result = chatMessage.getText();
        assertEquals(text, result);
    }
}
