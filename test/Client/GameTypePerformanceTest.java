package Client;

import models.game.GameType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTypePerformanceTest {

    @Test
    public void testGameTypeIterationPerformance() {
        long startTime = System.nanoTime();

        // Iterate through all values of GameType
        for (GameType type : GameType.values()) {
            System.out.println("Processing type: " + type);
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        // Assert that the iteration completes within a certain time frame (e.g., 100 ms)
        assertTrue(executionTime < 100, "GameType iteration took too long to execute");
    }
}
