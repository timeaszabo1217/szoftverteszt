package Client.model.message;

import models.account.TempAccount;
import models.message.AccountCopyMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountCopyMessageTest {

    private AccountCopyMessage accountCopyMessage;

    @BeforeEach
    void setup() {
        accountCopyMessage = new AccountCopyMessage();
    }

    @Test
    void testGetAccount() {
        assertNull(accountCopyMessage.getAccount());
    }
}
