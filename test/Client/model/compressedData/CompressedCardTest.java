package Client.model.compressedData;

import models.comperessedData.CompressedCard;
import models.card.AttackType;
import models.card.CardType;
import models.comperessedData.CompressedSpell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CompressedCardTest {

    private CompressedCard compressedCard;
    private CompressedSpell mockSpell;

    @BeforeEach
    void setUp() {
        mockSpell = mock(CompressedSpell.class);

        compressedCard = new CompressedCard(
                "testSprite",
                "testDescription",
                "card123",
                CardType.HERO,
                mockSpell,
                5,
                10,
                3,
                AttackType.MELEE,
                2,
                true
        );
    }

    private Object getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    @Test
    void testConstructorFields() throws NoSuchFieldException, IllegalAccessException {
        assertEquals("Fuck", getPrivateField(compressedCard, "name"), "A name mező értéke 'Fuck' kell, hogy legyen.");
        assertEquals("testSprite", compressedCard.getSpriteName(), "A spriteName mező értéke 'testSprite' kell, hogy legyen.");
        assertEquals("testDescription", compressedCard.getDescription(), "A description mező értéke 'testDescription' kell, hogy legyen.");
        assertEquals("card123", compressedCard.getCardId(), "A cardId mező értéke 'card123' kell, hogy legyen.");
        assertEquals(CardType.HERO, compressedCard.getType(), "A type mező értéke CardType.HERO kell, hogy legyen.");
        assertEquals(mockSpell, compressedCard.getSpell(), "A spell mező értéke a mockSpell objektum kell, hogy legyen.");
        assertEquals(5, compressedCard.getDefaultAp(), "A defaultAp mező értéke 5 kell, hogy legyen.");
        assertEquals(10, compressedCard.getDefaultHp(), "A defaultHp mező értéke 10 kell, hogy legyen.");
        assertEquals(3, compressedCard.getMannaPoint(), "A mannaPoint mező értéke 3 kell, hogy legyen.");
        assertEquals(AttackType.MELEE, compressedCard.getAttackType(), "Az attackType mező értéke AttackType.MELEE kell, hogy legyen.");
        assertEquals(2, compressedCard.getRange(), "A range mező értéke 2 kell, hogy legyen.");
        assertTrue(compressedCard.isHasCombo(), "A hasCombo mező értéke true kell, hogy legyen.");
    }

    @Test
    void testEqualsMethod() {
        CompressedCard sameCard = new CompressedCard(
                "otherSprite",
                "otherDescription",
                "card123",
                CardType.SPELL,
                mockSpell,
                7,
                8,
                1,
                AttackType.RANGED,
                3,
                false
        );

        CompressedCard differentCard = new CompressedCard(
                "differentSprite",
                "differentDescription",
                "card999",
                CardType.MINION,
                mockSpell,
                4,
                5,
                2,
                AttackType.HYBRID,
                1,
                false
        );

        assertEquals(compressedCard, sameCard, "Az equals metódusnak igaz értéket kell visszaadnia, ha azonos cardId-val rendelkeznek.");
        assertNotEquals(compressedCard, differentCard, "Az equals metódusnak hamis értéket kell visszaadnia, ha eltérő cardId-val rendelkeznek.");
    }

    @Test
    void testGetters() {
        assertEquals("Fuck", compressedCard.getName(), "A getName() visszaadott értéke 'Fuck' kell, hogy legyen.");
        assertEquals("testDescription", compressedCard.getDescription(), "A getDescription() visszaadott értéke 'testDescription' kell, hogy legyen.");
        assertEquals("card123", compressedCard.getCardId(), "A getCardId() visszaadott értéke 'card123' kell, hogy legyen.");
        assertEquals("testSprite", compressedCard.getSpriteName(), "A getSpriteName() visszaadott értéke 'testSprite' kell, hogy legyen.");
        assertEquals(CardType.HERO, compressedCard.getType(), "A getType() visszaadott értéke CardType.HERO kell, hogy legyen.");
        assertEquals(mockSpell, compressedCard.getSpell(), "A getSpell() visszaadott értéke a mockSpell objektum kell, hogy legyen.");
        assertEquals(5, compressedCard.getDefaultAp(), "A getDefaultAp() visszaadott értéke 5 kell, hogy legyen.");
        assertEquals(10, compressedCard.getDefaultHp(), "A getDefaultHp() visszaadott értéke 10 kell, hogy legyen.");
        assertEquals(3, compressedCard.getMannaPoint(), "A getMannaPoint() visszaadott értéke 3 kell, hogy legyen.");
        assertEquals(AttackType.MELEE, compressedCard.getAttackType(), "A getAttackType() visszaadott értéke AttackType.MELEE kell, hogy legyen.");
        assertEquals(2, compressedCard.getRange(), "A getRange() visszaadott értéke 2 kell, hogy legyen.");
        assertTrue(compressedCard.isHasCombo(), "A isHasCombo() visszaadott értéke true kell, hogy legyen.");
    }

    @Test
    void testGetPrice() {
        assertEquals(0, compressedCard.getPrice(), "A getPrice() visszaadott értéke 0 kell, hogy legyen.");
    }
}
