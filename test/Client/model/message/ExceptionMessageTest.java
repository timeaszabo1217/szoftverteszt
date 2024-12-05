package Client.model.message;

import models.message.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ExceptionMessageTest {
    private String exceptionString;
    private ExceptionMessage exceptionMessage;

    @BeforeEach
    void setup() {
        exceptionString = "Baj";
        exceptionMessage = new ExceptionMessage();
    }

    @Test
    void getExceptionString() {
        assertNull(exceptionMessage.getExceptionString());
    }
}
