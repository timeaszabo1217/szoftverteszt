package tests.Client.performanceTests.model.game;

import models.game.GameType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTypePerformanceTest {

    @Test
    public void testGameTypeIterationPerformance() {
        long startTime = System.nanoTime();

        for (GameType type : GameType.values()) {
            System.out.println("Processing type: " + type);
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        assertTrue(executionTime < 100, "GameType iteration took too long to execute");
    }

    @Test
    public void testGameTypeValues() {
        for (GameType type : GameType.values()) {
            assertNotNull(type, "GameType should have a valid value.");
        }
    }
}
