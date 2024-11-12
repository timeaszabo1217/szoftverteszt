package Client;

import models.message.Message;
import static models.Constants.SERVER_NAME;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessagePerformanceTest {
    @Test
    public void testMessageCreationPerformance() {
        long startTime = System.nanoTime();

        // Create a simple attack message
        Message message = Message.makeAttackMessage(SERVER_NAME, "attacker123", "defender456");

        System.out.println(message.getSender());
        System.out.println(message.getReceiver());
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        // Assert that the message creation completes within a certain time frame (e.g., 100 ms)
        assertTrue(executionTime < 100, "Message creation took too long to execute");
    }
}
