package Client.model.exceptions;

import models.exceptions.InputException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputExceptionPerformanceTest {
    @Test
    public void testInputExceptionPerformance() {
        long startTime = System.nanoTime();

        try {
            throw new InputException("Test exception");
        } catch (InputException e) {
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time: " + executionTime + " ms");

        assertTrue(executionTime < 20, "InputException handling took too long to execute");
    }
}
