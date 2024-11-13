package tests.Client.performanceTests.model.account;

import models.account.AccountType;
import models.account.Collection;
import models.account.MatchHistory;
import models.account.TempAccount;
import models.card.Deck;
import models.card.TempDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TempAccountTest {

    private TempAccount tempAccount;

    @BeforeEach
    public void setUp() {
        tempAccount = new TempAccount();
    }

    @Test
    public void testGetUsername() {
        setField(tempAccount, "username", "TestUser");
        assertEquals("TestUser", tempAccount.getUsername());
    }

    @Test
    public void testGetCollection() {
        Collection mockCollection = new Collection();
        setField(tempAccount, "collection", mockCollection);
        assertEquals(mockCollection, tempAccount.getCollection());
    }

    @Test
    public void testGetDecks() {
        Deck mockDeck = mock(Deck.class);
        when(mockDeck.getName()).thenReturn("TestDeck");

        TempDeck tempDeck = new TempDeck(mockDeck);

        List<TempDeck> mockDecks = new ArrayList<>();
        mockDecks.add(tempDeck);

        setField(tempAccount, "decks", mockDecks);

        assertEquals(mockDecks, tempAccount.getDecks());
    }

    @Test
    public void testGetMainDeckName() {
        setField(tempAccount, "mainDeckName", "MainDeck");
        assertEquals("MainDeck", tempAccount.getMainDeckName());
    }

    @Test
    public void testGetMatchHistories() {
        List<MatchHistory> mockHistories = new ArrayList<>();
        MatchHistory mockHistory = new MatchHistory();
        setField(mockHistory, "oppName", "Opponent1");
        mockHistories.add(mockHistory);
        setField(tempAccount, "matchHistories", mockHistories);
        assertEquals(mockHistories, tempAccount.getMatchHistories());
    }

    @Test
    public void testGetMoney() {
        setField(tempAccount, "money", 500);
        assertEquals(500, tempAccount.getMoney());
    }

    @Test
    public void testGetWins() {
        setField(tempAccount, "wins", 10);
        assertEquals(10, tempAccount.getWins());
    }

    @Test
    public void testGetAccountType() {
        setField(tempAccount, "accountType", AccountType.NORMAL);
        assertEquals(AccountType.NORMAL, tempAccount.getAccountType());
    }


    private void setField(Object target, String fieldName, Object value) {
        try {
            var field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
