package tests.Client.performanceTests.model.card;

import models.card.Card;
import models.card.CardType;
import models.card.AttackType;
import models.card.spell.Spell;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void testCardCreation() {
        ArrayList<Spell> spells = new ArrayList<>();
        Card card = new Card("Dragon", "C123", "A powerful dragon", "dragon_sprite",
                CardType.MINION, spells, 5, 10, 3, 100, AttackType.MELEE, 2, true);

        assertEquals("Dragon", card.getName(), "Card name should be 'Dragon'.");
        assertEquals("A powerful dragon", card.getDescription(), "Card description should match.");
        assertEquals("C123", card.getCardId(), "Card ID should match.");
        assertEquals("dragon_sprite", card.getSpriteName(), "Sprite name should match.");
        assertEquals(CardType.MINION, card.getType(), "Card type should be MINION.");
        assertEquals(5, card.getDefaultAp(), "Default AP should be 5.");
        assertEquals(10, card.getDefaultHp(), "Default HP should be 10.");
        assertEquals(3, card.getMannaPoint(), "Manna point should be 3.");
        assertEquals(100, card.getPrice(), "Price should be 100.");
        assertEquals(AttackType.MELEE, card.getAttackType(), "Attack type should be MELEE.");
        assertEquals(2, card.getRange(), "Range should be 2.");
        assertTrue(card.hasCombo(), "Card should have combo enabled.");
    }

    @Test
    public void testCardEquality() {
        Card card1 = new Card("Dragon", "C123", "Description", "sprite", CardType.MINION, new ArrayList<>(), 5, 10, 3, 100, AttackType.MELEE, 2, true);
        Card card2 = new Card("Phoenix", "C123", "Another description", "sprite2", CardType.SPELL, new ArrayList<>(), 4, 8, 2, 80, AttackType.RANGED, 3, false);

        assertEquals(card1, card2, "Cards with the same ID should be equal.");
    }

    @Test
    public void testCardNameContains() {
        Card card = new Card("Dragon Slayer", "C124", "Description", "sprite", CardType.MINION, new ArrayList<>(), 5, 10, 3, 100, AttackType.MELEE, 2, true);

        assertTrue(card.nameContains("dragon"), "Name should contain 'dragon'.");
        assertFalse(card.nameContains("phoenix"), "Name should not contain 'phoenix'.");
    }

    @Test
    public void testCardRemainingNumber() {
        Card card = new Card();
        card.setRemainingNumber(5);

        assertEquals(5, card.getRemainingNumber(), "Remaining number should be 5.");
        card.setRemainingNumber(3);
        assertEquals(3, card.getRemainingNumber(), "Remaining number should be updated to 3.");
    }
}
