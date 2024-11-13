package Client.model.card;

import models.card.Card;
import models.card.Deck;
import models.card.ExportedDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ExportedDeckTest {

    private Deck mockDeck;
    private Card mockHero;
    private Card mockItem;
    private Card mockMinion1;
    private Card mockMinion2;
    private ExportedDeck exportedDeck;

    @BeforeEach
    void setUp() {
        mockDeck = mock(Deck.class);
        mockHero = mock(Card.class);
        mockItem = mock(Card.class);
        mockMinion1 = mock(Card.class);
        mockMinion2 = mock(Card.class);

        when(mockDeck.getName()).thenReturn("TestDeck");
        when(mockDeck.getHero()).thenReturn(mockHero);
        when(mockDeck.getItem()).thenReturn(mockItem);
        when(mockDeck.getOthers()).thenReturn(List.of(mockMinion1, mockMinion2, mockMinion1));

        when(mockHero.getName()).thenReturn("HeroCard");
        when(mockItem.getName()).thenReturn("ItemCard");
        when(mockMinion1.getName()).thenReturn("MinionCard1");
        when(mockMinion2.getName()).thenReturn("MinionCard2");

        exportedDeck = new ExportedDeck(mockDeck);
    }

    @Test
    void testExportedDeckProperties() {
        assertEquals("TestDeck", exportedDeck.getName(), "The name should match the Deck's name.");
        assertEquals("HeroCard", exportedDeck.getHeroName(), "The hero name should match the hero card's name.");
        assertEquals("ItemCard", exportedDeck.getItemName(), "The item name should match the item card's name.");
    }

    @Test
    void testOtherCardsMapping() {
        Map<String, Integer> otherCards = exportedDeck.getOtherCards();

        assertEquals(2, otherCards.size(), "There should be two unique minion cards.");
        assertEquals(2, otherCards.get("MinionCard1"), "MinionCard1 should have a count of 2.");
        assertEquals(1, otherCards.get("MinionCard2"), "MinionCard2 should have a count of 1.");
    }

    @Test
    void testOtherCardsAreImmutable() {
        Map<String, Integer> otherCards = exportedDeck.getOtherCards();
        assertThrows(UnsupportedOperationException.class, () -> otherCards.put("NewMinion", 1), "The otherCards map should be immutable.");
    }
}
