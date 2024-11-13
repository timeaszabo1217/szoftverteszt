package Client.model.account;

import models.account.Account;
import models.account.AccountType;
import models.account.Collection;
import models.account.TempAccount;
import models.card.TempDeck;
import models.account.MatchHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountTest {
    private Account account;
    private TempDeck tempDeck;
    private Collection mockCollection;
    private List<TempDeck> mockDecks;
    private List<MatchHistory> mockMatchHistories;

    @BeforeEach
    public void setUp() {
        mockCollection = mock(Collection.class);
        mockDecks = new ArrayList<>();
        mockMatchHistories = new ArrayList<>();

        tempDeck = mock(TempDeck.class);
        when(tempDeck.getDeckName()).thenReturn("mainDeck");

        mockDecks.add(tempDeck);

        TempAccount mockTempAccount = mock(TempAccount.class);
        when(mockTempAccount.getUsername()).thenReturn("TestUser");
        when(mockTempAccount.getCollection()).thenReturn(mockCollection);
        when(mockTempAccount.getDecks()).thenReturn(mockDecks);
        when(mockTempAccount.getMainDeckName()).thenReturn("mainDeck");
        when(mockTempAccount.getMatchHistories()).thenReturn(mockMatchHistories);
        when(mockTempAccount.getMoney()).thenReturn(100);
        when(mockTempAccount.getAccountType()).thenReturn(AccountType.NORMAL);

        account = new Account(mockTempAccount);
    }

    @Test
    public void testAccountInitialization() {
        assertEquals("TestUser", account.getUsername());
        assertEquals(100, account.getMoney());
        assertEquals(AccountType.NORMAL, account.getAccountType());
        assertEquals(mockMatchHistories, account.getMatchHistories());
    }
}
