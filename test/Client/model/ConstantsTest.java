package Client.model;

import models.Constants;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantsTest {

    @Test
    void testConstants() {
        assertEquals(8888, Constants.PORT);
        assertEquals("localhost", Constants.SERVER_IP);
        assertEquals("Server", Constants.SERVER_NAME);
        assertEquals(KeyCode.T, Constants.KEY_FOR_CHAT);
    }
}
