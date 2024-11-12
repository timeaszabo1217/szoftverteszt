package tests.Client.performanceTests;

import models.comperessedData.CompressedCard;
import models.comperessedData.CompressedPlayer;
import models.comperessedData.CompressedTroop;
import models.card.CardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CompressedPlayerTest {

    private CompressedPlayer player;
    private CompressedCard mockCard;
    private CompressedTroop mockTroop;

    @BeforeEach
    public void setUp() {
        mockCard = mock(CompressedCard.class);
        mockTroop = mock(CompressedTroop.class);
        player = new CompressedPlayer("player123", 100, new ArrayList<>(), new ArrayList<>(), mockCard, new ArrayList<>(), 1, 0, new ArrayList<>(), mockTroop);
    }

    @Test
    public void testGetUserName() {
        assertEquals("player123", player.getUserName(), "Username should be set correctly.");
    }

    @Test
    public void testGetCurrentMP() {
        assertEquals(100, player.getCurrentMP(), "Current MP should be set correctly.");
    }

    @Test
    public void testGetHandAndAddNextCardToHand() {
        player.addNextCardToHand();
        assertTrue(player.getHand().contains(mockCard), "Hand should contain the next card.");
    }

    @Test
    public void testAddCardToNext() {
        CompressedCard newCard = mock(CompressedCard.class);
        when(newCard.getCardId()).thenReturn("testCardId");


        player.addCardToNext(newCard);

        assertEquals(newCard, player.getNextCard(), "Next card should be updated.");
    }


    @Test
    public void testAddCardToCollectedItems() {
        CompressedCard collectedItem = mock(CompressedCard.class);
        player.addCardToCollectedItems(collectedItem);
        assertTrue(player.getCollectedItems().contains(collectedItem), "Collected items should contain the new item.");
    }

    @Test
    public void testAddCardToGraveYard() {
        player.addCardToGraveYard(mockCard);
        assertTrue(player.getGraveyard().contains(mockCard), "Graveyard should contain the added card.");
    }

    @Test
    public void testTroopUpdate() {
        when(mockCard.getCardId()).thenReturn("testCardId");
        when(mockTroop.getCurrentHp()).thenReturn(50);
        when(mockTroop.getCard()).thenReturn(mockCard);
        when(mockCard.getType()).thenReturn(CardType.HERO);

        player.troopUpdate(mockTroop);

        assertTrue(player.getTroops().contains(mockTroop), "Troops should contain the updated troop.");
        assertEquals(mockTroop, player.getHero(), "Hero should be updated to the new troop.");
    }

    @Test
    public void testRemoveCardFromHand() {
        when(mockCard.getCardId()).thenReturn("card123");

        player.addNextCardToHand();

        player.removeCardFromHand("card123");

        assertFalse(player.getHand().contains(mockCard), "Hand should not contain the removed card.");
    }


    @Test
    public void testRemoveCardFromNext() {
        player.removeCardFromNext();
        assertNull(player.getNextCard(), "Next card should be removed.");
    }

    @Test
    public void testRemoveCardFromCollectedItems() {
        when(mockCard.getCardId()).thenReturn("card123");
        player.addCardToCollectedItems(mockCard);
        player.removeCardFromCollectedItems(mockCard.getCardId());
        assertFalse(player.getCollectedItems().contains(mockCard), "Collected items should not contain the removed card.");
    }

    @Test
    public void testRemoveTroop() {
        when(mockCard.getCardId()).thenReturn("testCardId");
        when(mockTroop.getCard()).thenReturn(mockCard);
        player.troopUpdate(mockTroop);
        player.removeTroop(mockCard.getCardId());

        assertFalse(player.getTroops().contains(mockTroop), "Troops should not contain the removed troop.");
        assertNull(player.getHero(), "Hero should be null after hero troop is removed.");
    }

    @Test
    public void testSetAndGetHero() {
        CompressedCard mockCard = mock(CompressedCard.class);
        when(mockCard.getType()).thenReturn(CardType.HERO);

        when(mockTroop.getCard()).thenReturn(mockCard);

        player.setTroops(List.of(mockTroop));

        assertEquals(mockTroop, player.getHero(), "Hero should be set correctly.");
    }


    @Test
    public void testSetCurrentMP() {
        player.setCurrentMP(80, 1);
        assertEquals(80, player.getCurrentMP(), "Current MP should be updated correctly.");
    }

    @Test
    public void testFlagCarriers() {
        when(mockTroop.getNumberOfCollectedFlags()).thenReturn(1);
        when(mockCard.getCardId()).thenReturn("testCardId");
        when(mockTroop.getCard()).thenReturn(mockCard);
        player.setTroops(List.of(mockTroop));

        List<CompressedTroop> flagCarriers = player.getFlagCarriers();
        assertEquals(1, flagCarriers.size(), "There should be 1 flag carrier.");
        assertEquals(mockTroop, flagCarriers.get(0), "Flag carrier should match the troop.");
    }

    @Test
    public void testPropertyChangeListeners() {
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        player.addPropertyChangeListener(listener);

        player.addNextCardToHand();

        verify(listener, times(1)).propertyChange(any(PropertyChangeEvent.class));
    }
}
