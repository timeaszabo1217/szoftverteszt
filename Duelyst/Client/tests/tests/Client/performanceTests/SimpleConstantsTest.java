package tests.Client.performanceTests;

import models.Constants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SimpleConstantsTest {

    @Test
    public void testServerNameConstant() {
        assertNotNull(Constants.SERVER_NAME, "SERVER_NAME should not be null.");
    }

    @Test
    public void testServerPortConstant() {
        assertNotNull(Constants.PORT, "PORT should not be null or zero.");
    }
}
