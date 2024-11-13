package Client.model.account;

import models.account.AccountInfo;
import models.account.AccountType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountInfoTest {

    @Test
    public void testAccountInfoValues() {
        AccountInfo accountInfo = new AccountInfo();

        accountInfo.setType(AccountType.NORMAL);

        assertNull(accountInfo.getUsername(), "Username should initially be null.");
        assertFalse(accountInfo.isOnline(), "Account should initially be offline.");
        assertEquals(0, accountInfo.getWins(), "Initial wins should be 0.");
        assertEquals(AccountType.NORMAL, accountInfo.getType(), "Account type should match.");
    }
}
