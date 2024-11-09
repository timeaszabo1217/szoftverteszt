package Server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.dataCenter.models.account.Account;
import server.dataCenter.models.account.TempAccount;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        TempAccount tempAccount = mock(TempAccount.class);
        when(tempAccount.getUsername()).thenReturn("testUser");

        account = new Account(tempAccount);
    }

    @Test
    public void testGetUsername() {
        assertEquals("testUser", account.getUsername());
    }
}
