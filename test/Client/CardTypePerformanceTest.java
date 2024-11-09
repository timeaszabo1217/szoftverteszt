package Client;

import models.card.CardType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTypePerformanceTest {

    @Test
    public void testCardTypeIterationPerformance() {
        long startTime = System.nanoTime();

        // Iterate through all values of CardType
        for (CardType type : CardType.values()) {
            System.out.println("Processing type: " + type);
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        // Assert that the iteration completes within a certain time frame (e.g., 100 ms)
        assertTrue(executionTime < 100, "CardType iteration took too long to execute");
    }
}
