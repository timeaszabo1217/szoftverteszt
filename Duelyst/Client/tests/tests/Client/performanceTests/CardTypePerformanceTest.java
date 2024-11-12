package tests.Client.performanceTests;

import models.card.CardType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTypePerformanceTest {

    @Test
    public void testCardTypeIterationPerformance() {
        long startTime = System.nanoTime();

        for (CardType type : CardType.values()) {
            System.out.println("Processing type: " + type);
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        assertTrue(executionTime < 100, "CardType iteration took too long to execute");
    }

    @Test
    public void testCardTypeValues() {
        for (CardType type : CardType.values()) {
            assertNotNull(type, "CardType should have a valid value.");
        }
    }
}
