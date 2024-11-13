package tests.Client.performanceTests.model.card.spell;

import models.card.spell.TargetCardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TargetCardTypeTest {

    private TargetCardType targetCardType;
    private TargetCardType copiedTargetCardType;

    @BeforeEach
    void setUp() {
        targetCardType = new TargetCardType(true, false, true, false);
        copiedTargetCardType = new TargetCardType(targetCardType);
    }

    private Object getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    @Test
    void testConstructorWithBooleans() throws NoSuchFieldException, IllegalAccessException {
        assertTrue((boolean) getPrivateField(targetCardType, "cell"), "A cell értékének igaznak kell lennie.");
        assertFalse((boolean) getPrivateField(targetCardType, "hero"), "A hero értékének hamisnak kell lennie.");
        assertTrue((boolean) getPrivateField(targetCardType, "minion"), "A minion értékének igaznak kell lennie.");
        assertFalse((boolean) getPrivateField(targetCardType, "player"), "A player értékének hamisnak kell lennie.");
    }

    @Test
    void testCopyConstructor() throws NoSuchFieldException, IllegalAccessException {
        assertEquals(getPrivateField(targetCardType, "cell"), getPrivateField(copiedTargetCardType, "cell"), "A cell értékének meg kell egyeznie az eredeti objektummal.");
        assertEquals(getPrivateField(targetCardType, "hero"), getPrivateField(copiedTargetCardType, "hero"), "A hero értékének meg kell egyeznie az eredeti objektummal.");
        assertEquals(getPrivateField(targetCardType, "minion"), getPrivateField(copiedTargetCardType, "minion"), "A minion értékének meg kell egyeznie az eredeti objektummal.");
        assertEquals(getPrivateField(targetCardType, "player"), getPrivateField(copiedTargetCardType, "player"), "A player értékének meg kell egyeznie az eredeti objektummal.");
    }

    @Test
    void testIsCell() {
        assertTrue(targetCardType.isCell(), "A cell értékének igaznak kell lennie a getter szerint.");
    }

    @Test
    void testIsHero() {
        assertFalse(targetCardType.isHero(), "A hero értékének hamisnak kell lennie a getter szerint.");
    }

    @Test
    void testIsMinion() {
        assertTrue(targetCardType.isMinion(), "A minion értékének igaznak kell lennie a getter szerint.");
    }

    @Test
    void testIsPlayer() {
        assertFalse(targetCardType.isPlayer(), "A player értékének hamisnak kell lennie a getter szerint.");
    }
}
