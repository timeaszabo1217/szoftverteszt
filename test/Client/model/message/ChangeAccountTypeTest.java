package Client.model.message;

import models.account.AccountType;
import models.message.ChangeAccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeAccountTypeTest {

    private ChangeAccountType changeAccountType;
    private String username;
    private AccountType accountType;

    @BeforeEach
    void setup() {
        username = "testUser";
        accountType = AccountType.ADMIN;
        changeAccountType = new ChangeAccountType(username, accountType);
    }

    @Test
    void testGetUsername() {
        var result = changeAccountType.getUsername();
        assertEquals(username, result);
    }

    @Test
    void testGetNewType() {
        var result = changeAccountType.getNewType();
        assertEquals(accountType, result);
    }
}
