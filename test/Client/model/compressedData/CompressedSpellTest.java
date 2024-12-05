package Client.model.compressedData;

import models.card.spell.AvailabilityType;
import models.card.spell.Target;
import models.comperessedData.CompressedSpell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CompressedSpellTest {

    private CompressedSpell compressedSpell;
    private Target mockTarget;
    private AvailabilityType mockAvailabilityType;

    @BeforeEach
    void setUp() {
        mockTarget = mock(Target.class);
        mockAvailabilityType = mock(AvailabilityType.class);

        compressedSpell = new CompressedSpell(
                "spell123",
                mockTarget,
                mockAvailabilityType,
                3,
                5,
                2
        );
    }

    @Test
    void testConstructorFields() {
        assertEquals("spell123", compressedSpell.getSpellId(), "A spellId értéke 'spell123' kell, hogy legyen.");
        assertEquals(mockTarget, compressedSpell.getTarget(), "A target mező értéke a mockTarget objektum kell, hogy legyen.");
        assertEquals(mockAvailabilityType, compressedSpell.getAvailabilityType(), "Az availabilityType mező értéke a mockAvailabilityType objektum kell, hogy legyen.");
        assertEquals(3, compressedSpell.getCoolDown(), "A coolDown értéke 3 kell, hogy legyen.");
        assertEquals(5, compressedSpell.getMannaPoint(), "A mannaPoint értéke 5 kell, hogy legyen.");
        assertEquals(2, compressedSpell.getLastTurnUsed(), "A lastTurnUsed értéke 2 kell, hogy legyen.");
    }

    @Test
    void testIsCoolDown_NotInCoolDown() {
        boolean result = compressedSpell.isCoolDown(1);
        assertFalse(result, "Az isCoolDown(1) visszaadott értékének false-nak kell lennie, mivel a lastTurnUsed 2 és a coolDown 3.");
    }

    @Test
    void testIsCoolDown_InCoolDown() {
        boolean result = compressedSpell.isCoolDown(7);
        assertTrue(result, "Az isCoolDown(7) visszaadott értékének true-nak kell lennie, mivel a lastTurnUsed 2 és a coolDown 3.");
    }

    @Test
    void testIsCoolDown_ZeroLastTurnUsed() {
        compressedSpell = new CompressedSpell("spell123", mockTarget, mockAvailabilityType, 3, 5, 0);
        boolean result = compressedSpell.isCoolDown(10);
        assertFalse(result, "Az isCoolDown() visszaadott értékének false-nak kell lennie, mivel a lastTurnUsed értéke 0.");
    }
}
