package Client.model.account;

import models.account.Collection;
import models.card.Card;
import models.card.Deck;
import models.card.CardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CollectionTest {

    private Collection collection;
    private Card heroCard;
    private Card minionCard;
    private Card spellCard;
    private Card itemCard;

    @BeforeEach
    public void setUp() {
        collection = new Collection();

        heroCard = mock(Card.class);
        when(heroCard.getType()).thenReturn(CardType.HERO);
        when(heroCard.getCardId()).thenReturn("hero1");
        when(heroCard.isSameAs("hero1")).thenReturn(true);

        minionCard = mock(Card.class);
        when(minionCard.getType()).thenReturn(CardType.MINION);
        when(minionCard.getCardId()).thenReturn("minion1");
        when(minionCard.isSameAs("minion1")).thenReturn(true);

        spellCard = mock(Card.class);
        when(spellCard.getType()).thenReturn(CardType.SPELL);
        when(spellCard.getCardId()).thenReturn("spell1");
        when(spellCard.isSameAs("spell1")).thenReturn(true);

        itemCard = mock(Card.class);
        when(itemCard.getType()).thenReturn(CardType.USABLE_ITEM);
        when(itemCard.getCardId()).thenReturn("item1");
        when(itemCard.isSameAs("item1")).thenReturn(true);

        collection.addCard(heroCard);
        collection.addCard(minionCard);
        collection.addCard(spellCard);
        collection.addCard(itemCard);
    }

    @Test
    public void testAddCard() {
        assertEquals(1, collection.getHeroes().size());
        assertEquals(1, collection.getMinions().size());
        assertEquals(1, collection.getSpells().size());
        assertEquals(1, collection.getItems().size());
    }

    @Test
    public void testGetCardByName() {
        Card foundCard = collection.getCard("hero1");
        assertEquals(heroCard, foundCard);
    }

    @Test
    public void testFindLastCard() {
        Card lastCard = collection.findLast("item1");
        assertEquals(itemCard, lastCard);
    }

    @Test
    public void testSearchCollection() {
        Collection result = collection.searchCollection("spell1");
        assertEquals(1, result.getSpells().size());
        assertTrue(result.getSpells().contains(spellCard));
    }

    @Test
    public void testRemoveCard() {
        Card removedCard = collection.removeCard("minion1");
        assertEquals(minionCard, removedCard);
        assertTrue(collection.getMinions().isEmpty());
    }

    @Test
    public void testFindHero() {
        Card foundHero = collection.findHero("hero1");
        assertEquals(heroCard, foundHero);
    }

    @Test
    public void testFindItem() {
        Card foundItem = collection.findItem("item1");
        assertEquals(itemCard, foundItem);
    }

    @Test
    public void testFindOthers() {
        Card foundMinion = collection.findOthers("minion1");
        assertEquals(minionCard, foundMinion);
    }

    @Test
    public void testCanAddCardToDeck() {
        Deck mockDeck = mock(Deck.class);
        when(mockDeck.hasHero(heroCard)).thenReturn(false);

        String cardId = collection.canAddCardTo("hero1", mockDeck);
        assertEquals("hero1", cardId);
    }

    @Test
    public void testCountCardOccurrences() {
        assertEquals(1, collection.count("hero1"));
        assertEquals(1, collection.count("minion1"));
    }

    @Test
    public void testEquals() {
        Collection otherCollection = new Collection();
        otherCollection.addCard(heroCard);
        otherCollection.addCard(minionCard);
        otherCollection.addCard(spellCard);
        otherCollection.addCard(itemCard);

        assertTrue(collection.equals(otherCollection));
    }
}
