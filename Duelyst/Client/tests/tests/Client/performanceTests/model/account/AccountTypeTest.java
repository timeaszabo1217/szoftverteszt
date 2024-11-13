package tests.Client.performanceTests.model.account;

import models.account.AccountType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTypeTest {

    @Test
    public void testEnumValues() {
        AccountType[] expectedValues = {AccountType.ADMIN, AccountType.NORMAL};
        assertArrayEquals(expectedValues, AccountType.values());
    }

    @Test
    public void testEnumValueOf() {
        assertEquals(AccountType.ADMIN, AccountType.valueOf("ADMIN"));
        assertEquals(AccountType.NORMAL, AccountType.valueOf("NORMAL"));
    }

    @Test
    public void testEnumName() {
        assertEquals("ADMIN", AccountType.ADMIN.name());
        assertEquals("NORMAL", AccountType.NORMAL.name());
    }
}
