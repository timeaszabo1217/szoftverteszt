package tests.Client.performanceTests;

import models.message.Message;
import static models.Constants.SERVER_NAME;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessagePerformanceTest {
    @Test
    public void testMessageCreationPerformance() {
        long startTime = System.nanoTime();

        Message message = Message.makeAttackMessage(SERVER_NAME, "attacker123", "defender456");

        System.out.println(message.getSender());
        System.out.println(message.getReceiver());
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        assertTrue(executionTime < 50, "Message creation took too long to execute");
    }
}
