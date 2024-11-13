package Client.model.card;

import models.card.Card;
import models.card.Deck;
import models.card.TempDeck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TempDeckTest {

    private Deck mockDeck;
    private Card mockHero;
    private Card mockItem;
    private Card mockOtherCard1;
    private Card mockOtherCard2;
    private TempDeck tempDeck;

    @BeforeEach
    void setUp() {
        mockDeck = mock(Deck.class);
        mockHero = mock(Card.class);
        mockItem = mock(Card.class);
        mockOtherCard1 = mock(Card.class);
        mockOtherCard2 = mock(Card.class);

        when(mockDeck.getName()).thenReturn("TestDeck");
        when(mockDeck.getHero()).thenReturn(mockHero);
        when(mockDeck.getItem()).thenReturn(mockItem);
        when(mockDeck.getOthers()).thenReturn(List.of(mockOtherCard1, mockOtherCard2));

        when(mockHero.getCardId()).thenReturn("HeroID");
        when(mockItem.getCardId()).thenReturn("ItemID");
        when(mockOtherCard1.getCardId()).thenReturn("OtherCardID1");
        when(mockOtherCard2.getCardId()).thenReturn("OtherCardID2");

        tempDeck = new TempDeck(mockDeck);
    }

    @Test
    void testTempDeckProperties() {
        assertEquals("TestDeck", tempDeck.getDeckName(), "Deck name should match the original Deck's name.");
        assertEquals("HeroID", tempDeck.getHeroId(), "Hero ID should match the hero's card ID.");
        assertEquals("ItemID", tempDeck.getItemId(), "Item ID should match the item's card ID.");
    }

    @Test
    void testOtherCardsIds() {
        List<String> othersIds = tempDeck.getOthersIds();

        assertEquals(2, othersIds.size(), "There should be two other card IDs.");
        assertTrue(othersIds.contains("OtherCardID1"), "Other cards should include 'OtherCardID1'.");
        assertTrue(othersIds.contains("OtherCardID2"), "Other cards should include 'OtherCardID2'.");
    }

    @Test
    void testOthersIdsImmutability() {
        List<String> othersIds = tempDeck.getOthersIds();
        assertThrows(UnsupportedOperationException.class, () -> othersIds.add("NewCardID"), "The list of other card IDs should be immutable.");
    }
}
