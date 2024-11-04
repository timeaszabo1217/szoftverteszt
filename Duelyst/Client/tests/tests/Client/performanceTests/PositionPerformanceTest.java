package tests.Client.performanceTests;

import models.game.map.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositionPerformanceTest {

    @Test
    public void testIsNextToPerformance() {
        Position pos1 = new Position(5, 5);
        Position pos2 = new Position(5, 6);

        long startTime = System.nanoTime();

        // Check if positions are next to each other
        boolean result = pos1.isNextTo(pos2);

        System.out.println(result);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        // Assert that the method completes within a certain time frame (e.g., 50 ms)
        assertTrue(executionTime < 50, "isNextTo method took too long to execute");
    }

    @Test
    public void testManhattanDistancePerformance() {
        Position pos1 = new Position(2, 3);
        Position pos2 = new Position(7, 8);

        long startTime = System.nanoTime();

        // Calculate Manhattan distance
        int distance = pos1.manhattanDistance(pos2);

        System.out.println(distance);
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        // Assert that the calculation completes within a certain time frame (e.g., 50 ms)
        assertTrue(executionTime < 50, "Manhattan distance calculation took too long to execute");
    }
}
