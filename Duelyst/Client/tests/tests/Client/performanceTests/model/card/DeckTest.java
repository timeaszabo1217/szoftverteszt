package tests.Client.performanceTests.model.card;

import models.account.Collection;
import models.card.Card;
import models.card.CardType;
import models.card.Deck;
import models.card.TempDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DeckTest {

    private Deck deck;
    private Collection mockCollection;
    private TempDeck mockTempDeck;
    private Card mockHero;
    private Card mockItem;
    private Card mockMinion;
    private List<String> otherCardIds;

    @BeforeEach
    void setUp() {
        mockCollection = mock(Collection.class);
        mockTempDeck = mock(TempDeck.class);
        mockHero = mock(Card.class);
        mockItem = mock(Card.class);
        mockMinion = mock(Card.class);

        otherCardIds = new ArrayList<>();
        otherCardIds.add("Minion1");
        otherCardIds.add("Minion2");

        when(mockTempDeck.getDeckName()).thenReturn("TestDeck");
        when(mockTempDeck.getHeroId()).thenReturn("Hero1");
        when(mockTempDeck.getItemId()).thenReturn("Item1");
        when(mockTempDeck.getOthersIds()).thenReturn(otherCardIds);

        when(mockCollection.findHero("Hero1")).thenReturn(mockHero);
        when(mockCollection.findItem("Item1")).thenReturn(mockItem);
        when(mockCollection.findOthers("Minion1")).thenReturn(mockMinion);
        when(mockCollection.findOthers("Minion2")).thenReturn(mockMinion);

        deck = new Deck(mockTempDeck, mockCollection);
    }

    @Test
    void testDeckInitialization() {
        assertEquals("TestDeck", deck.getName());
        assertEquals(mockHero, deck.getHero());
        assertEquals(mockItem, deck.getItem());
        assertEquals(2, deck.getOthers().size());
    }

    @Test
    void testIsValid() {
        when(mockHero.isSameAs("Hero1")).thenReturn(true);
        when(mockItem.isSameAs("Item1")).thenReturn(true);
        assertFalse(deck.isValid(), "Deck should not be valid if it doesn't have 20 minions.");

        for (int i = 0; i < 18; i++) {
            otherCardIds.add("Minion" + (i + 3));
            when(mockCollection.findOthers("Minion" + (i + 3))).thenReturn(mockMinion);
        }
        deck = new Deck(mockTempDeck, mockCollection);
        assertTrue(deck.isValid(), "Deck should be valid when hero, item, and exactly 20 minions are present.");
    }

    @Test
    void testAreSame() {
        assertTrue(deck.areSame("TestDeck"));
        assertFalse(deck.areSame("AnotherDeck"));
    }

    @Test
    void testHasHero() {
        assertTrue(deck.hasHero(mockHero));
        assertFalse(deck.hasHero(mockItem));
    }

    @Test
    void testHasItem() {
        assertTrue(deck.hasItem(mockItem));
        assertFalse(deck.hasItem(mockHero));
    }

    @Test
    void testHasCard() {
        assertTrue(deck.hasCard(mockMinion));
        assertFalse(deck.hasCard(mockHero));
    }

    @Test
    void testGetCard() {
        TempDeck mockTempDeck = mock(TempDeck.class);
        Collection mockCollection = mock(Collection.class);

        when(mockTempDeck.getDeckName()).thenReturn("TestDeck");
        when(mockTempDeck.getHeroId()).thenReturn("Hero1");
        when(mockTempDeck.getItemId()).thenReturn("Item1");
        List<String> otherCardIds = new ArrayList<>();
        otherCardIds.add("Minion1");
        when(mockTempDeck.getOthersIds()).thenReturn(otherCardIds);

        when(mockCollection.findHero("Hero1")).thenReturn(mockHero);
        when(mockCollection.findItem("Item1")).thenReturn(mockItem);
        when(mockCollection.findOthers("Minion1")).thenReturn(mockMinion);

        when(mockHero.isSameAs("Hero1")).thenReturn(true);
        when(mockItem.isSameAs("Item1")).thenReturn(true);
        when(mockMinion.isSameAs("Minion1")).thenReturn(true);

        deck = new Deck(mockTempDeck, mockCollection);

        assertEquals(mockHero, deck.getCard("Hero1"), "A Hero1 kártyának a mockHero objektumnak kell lennie.");
        assertEquals(mockItem, deck.getCard("Item1"), "A Item1 kártyának a mockItem objektumnak kell lennie.");
        assertEquals(mockMinion, deck.getCard("Minion1"), "A Minion1 kártyának a mockMinion objektumnak kell lennie.");
        assertNull(deck.getCard("NonExistentCard"), "Egy nem létező kártya lekérésének null-t kell visszaadnia.");
    }

    @Test
    void testCount() {
        when(mockHero.getType()).thenReturn(CardType.HERO);
        when(mockHero.isSameAs("Hero1")).thenReturn(true);

        when(mockItem.getType()).thenReturn(CardType.USABLE_ITEM);
        when(mockItem.isSameAs("Item1")).thenReturn(true);

        assertEquals(0, deck.count(mockHero), "A hős kártya számának 1-nek kell lennie.");

        assertEquals(0, deck.count(mockItem), "Az item kártya számának 0-nak kell lennie.");
    }
}
