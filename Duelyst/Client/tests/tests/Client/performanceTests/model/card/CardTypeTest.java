package tests.Client.performanceTests.model.card;

import models.card.AttackType;
import models.card.CardType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTypeTest {

    @Test
    public void testEnumValues() {
        CardType[] expectedValues = {CardType.HERO, CardType.MINION, CardType.SPELL
                , CardType.FLAG, CardType.USABLE_ITEM, CardType.COLLECTIBLE_ITEM};
        assertArrayEquals(expectedValues, CardType.values());
    }

    @Test
    public void testEnumValueOf() {
        assertEquals(CardType.HERO, CardType.valueOf("HERO"));
        assertEquals(CardType.MINION, CardType.valueOf("MINION"));
        assertEquals(CardType.SPELL, CardType.valueOf("SPELL"));
        assertEquals(CardType.FLAG, CardType.valueOf("FLAG"));
        assertEquals(CardType.USABLE_ITEM, CardType.valueOf("USABLE_ITEM"));
        assertEquals(CardType.COLLECTIBLE_ITEM, CardType.valueOf("COLLECTIBLE_ITEM"));
    }

    @Test
    public void testEnumName() {
        assertEquals("HERO", CardType.HERO.name());
        assertEquals("MINION", CardType.MINION.name());
        assertEquals("SPELL", CardType.SPELL.name());
        assertEquals("FLAG", CardType.FLAG.name());
        assertEquals("USABLE_ITEM", CardType.USABLE_ITEM.name());
        assertEquals("COLLECTIBLE_ITEM", CardType.COLLECTIBLE_ITEM.name());
    }
}
