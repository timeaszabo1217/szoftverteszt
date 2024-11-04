package tests.Client.performanceTests;

import controller.GameController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameControllerTest {

    /*
    * Nem jó, mert a game null. A bad_ verzióban kellene a gondolatmenetet folytatni.
    * */

    @Test
    public void testCalculateAvailableActionsPerformance() {
        GameController gameController = GameController.getInstance();

        // Start time measurement
        long startTime = System.nanoTime();

        // A metódus hívása, amelynek a teljesítményét tesztelni szeretnénk
        gameController.calculateAvailableActions();

        // End time measurement
        long endTime = System.nanoTime();

        // Calculate the execution time in milliseconds
        long executionTime = (endTime - startTime) / 1_000_000;

        // Print the execution time to the console
        System.out.println("Execution time: " + executionTime + " ms");

        // Assert that the execution time is under a certain threshold (e.g., 500 ms)
        assertTrue(executionTime < 500, "Method took too long to execute");
    }
}
