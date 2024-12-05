package Client.model.card.spell;

import models.card.spell.Spell;
import models.card.spell.SpellAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SpellActionTest {

    private Spell mockCarryingSpell;
    private SpellAction spellActionFull;
    private SpellAction spellActionBasic;

    @BeforeEach
    void setUp() {
        mockCarryingSpell = mock(Spell.class);

        spellActionFull = new SpellAction(
                1, 2, 3, 4, true, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, 0, -1, 1, mockCarryingSpell);

        // Initialize basic constructor
        spellActionBasic = new SpellAction(
                3, 4, 6, 2, false, false, true,
                true, false, false, true, false,
                false, true, 8, 5
        );
    }

    @Test
    void testFullConstructorFields() {
        // Check all boolean and int fields for the full constructor
        assertEquals(1, spellActionFull.getEnemyHitChanges());
        assertEquals(2, spellActionFull.getApChange());
        assertEquals(3, spellActionFull.getHpChange());
        assertEquals(4, spellActionFull.getMpChange());
        assertTrue(spellActionFull.isPoison());
        assertFalse(spellActionFull.isMakeStun());
        assertFalse(spellActionFull.isMakeDisarm());
        assertFalse(spellActionFull.isNoDisarm());
        assertFalse(spellActionFull.isNoPoison());
        assertFalse(spellActionFull.isNoStun());
        assertFalse(spellActionFull.isNoBadEffect());
        assertFalse(spellActionFull.isNoAttackFromWeakerOnes());
        assertFalse(spellActionFull.isDisableHolyBuff());
        assertFalse(spellActionFull.isAddSpell());
        assertFalse(spellActionFull.isKillsTarget());
        assertFalse(spellActionFull.isForGladiator());
        assertFalse(spellActionFull.isDurable());
        assertEquals(0, spellActionFull.getRemoveBuffs());
        assertEquals(Integer.MAX_VALUE, spellActionFull.getDuration()); // duration set to -1 in constructor
        assertEquals(1, spellActionFull.getDelay());
        assertEquals(mockCarryingSpell, spellActionFull.getCarryingSpell());
    }

    @Test
    void testBasicConstructorFields() {
        // Check fields for the basic constructor
        assertEquals(3, spellActionBasic.getEnemyHitChanges());
        assertEquals(4, spellActionBasic.getApChange());
        assertEquals(6, spellActionBasic.getHpChange());
        assertEquals(2, spellActionBasic.getMpChange());
        assertFalse(spellActionBasic.isPoison());
        assertFalse(spellActionBasic.isMakeStun());
        assertTrue(spellActionBasic.isMakeDisarm());
        assertTrue(spellActionBasic.isNoDisarm());
        assertFalse(spellActionBasic.isNoPoison());
        assertFalse(spellActionBasic.isNoStun());
        assertTrue(spellActionBasic.isNoBadEffect());
        assertFalse(spellActionBasic.isNoAttackFromWeakerOnes());
        assertFalse(spellActionBasic.isKillsTarget());
        assertTrue(spellActionBasic.isDurable());
        assertEquals(8, spellActionBasic.getDuration());
        assertEquals(5, spellActionBasic.getDelay());
        assertNull(spellActionBasic.getCarryingSpell()); // No carrying spell in basic constructor
    }

    @Test
    void testRemoveBuffsField() {
        assertEquals(0, spellActionFull.getRemoveBuffs(), "Remove buffs should be -1 in full constructor.");
        spellActionFull = new SpellAction(
                1, 2, 3, 4, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, 1, 7, 3, mockCarryingSpell
        );
        assertEquals(1, spellActionFull.getRemoveBuffs(), "Remove buffs should be 1 when set in constructor.");
    }

    @Test
    void testDurationFieldWithNormalValue() {
        // Testing duration when it's set to a regular positive integer
        SpellAction spellAction = new SpellAction(
                1, 2, 3, 4, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, 0, 5, 1, mockCarryingSpell
        );
        assertEquals(5, spellAction.getDuration(), "Duration should be 5 when set as a regular positive value.");
    }

    @Test
    void testDurationFieldWithInfiniteValue() {
        // Testing duration when set to -1 (interpreted as infinite duration)
        SpellAction spellAction = new SpellAction(
                1, 2, 3, 4, false, false, false,
                false, false, false, false, false, false,
                false, false, false, false, false, 0, -1, 1, mockCarryingSpell
        );
        assertEquals(Integer.MAX_VALUE, spellAction.getDuration(), "Duration should be Integer.MAX_VALUE when set to -1.");
    }
}

