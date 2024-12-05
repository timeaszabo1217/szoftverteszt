package Client.model.card.spell;

import models.card.spell.Target;
import models.card.spell.CardAttackType;
import models.card.spell.TargetCardType;
import models.card.spell.Owner;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TargetTest {

    private Position mockPosition;
    private Owner mockOwner;
    private TargetCardType mockCardType;
    private CardAttackType mockAttackType;
    private Target target;

    @BeforeEach
    void setUp() {
        mockPosition = mock(Position.class);
        mockOwner = mock(Owner.class);
        mockCardType = mock(TargetCardType.class);
        mockAttackType = mock(CardAttackType.class);

        target = new Target(
                true, // isRelatedToCardOwnerPosition
                true, // isForAroundOwnHero
                mockPosition, // dimensions
                true, // isRandom
                mockOwner, // owner
                mockCardType, // cardType
                mockAttackType, // attackType
                true // isForDeckCards
        );
    }

    private Object getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    @Test
    void testIsRelatedToCardOwnerPosition() throws NoSuchFieldException, IllegalAccessException {
        boolean value = (boolean) getPrivateField(target, "isRelatedToCardOwnerPosition");
        assertTrue(value, "Az isRelatedToCardOwnerPosition értékének igaznak kell lennie.");
    }

    @Test
    void testIsForAroundOwnHero() throws NoSuchFieldException, IllegalAccessException {
        boolean value = (boolean) getPrivateField(target, "isForAroundOwnHero");
        assertTrue(value, "Az isForAroundOwnHero értékének igaznak kell lennie.");
    }

    @Test
    void testDimensions() throws NoSuchFieldException, IllegalAccessException {
        Position value = (Position) getPrivateField(target, "dimensions");
        assertEquals(mockPosition, value, "A dimensions mező értékének meg kell egyeznie a mockPosition objektummal.");
    }

    @Test
    void testIsRandom() throws NoSuchFieldException, IllegalAccessException {
        boolean value = (boolean) getPrivateField(target, "isRandom");
        assertTrue(value, "Az isRandom értékének igaznak kell lennie.");
    }

    @Test
    void testOwner() throws NoSuchFieldException, IllegalAccessException {
        Owner value = (Owner) getPrivateField(target, "owner");
        assertEquals(mockOwner, value, "Az owner mező értékének meg kell egyeznie a mockOwner objektummal.");
    }

    @Test
    void testCardType() throws NoSuchFieldException, IllegalAccessException {
        TargetCardType value = (TargetCardType) getPrivateField(target, "cardType");
        assertEquals(mockCardType, value, "A cardType mező értékének meg kell egyeznie a mockCardType objektummal.");
    }

    @Test
    void testAttackType() throws NoSuchFieldException, IllegalAccessException {
        CardAttackType value = (CardAttackType) getPrivateField(target, "attackType");
        assertEquals(mockAttackType, value, "Az attackType mező értékének meg kell egyeznie a mockAttackType objektummal.");
    }

    @Test
    void testIsForDeckCards() throws NoSuchFieldException, IllegalAccessException {
        boolean value = (boolean) getPrivateField(target, "isForDeckCards");
        assertTrue(value, "Az isForDeckCards értékének igaznak kell lennie.");
    }
}
