package tests.Client.performanceTests.model.card.spell;

import models.card.spell.CardAttackType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardAttackTypeTest {

    private CardAttackType meleeAttackType;
    private CardAttackType rangedAttackType;
    private CardAttackType hybridAttackType;
    private CardAttackType noneAttackType;

    @BeforeEach
    void setUp() {
        meleeAttackType = new CardAttackType(true, false, false);
        rangedAttackType = new CardAttackType(false, true, false);
        hybridAttackType = new CardAttackType(false, false, true);
        noneAttackType = new CardAttackType(false, false, false);
    }

    @Test
    void testIsMelee() {
        assertTrue(meleeAttackType.isMelee(), "A meleeAttackType melee értékének igaznak kell lennie.");
        assertFalse(rangedAttackType.isMelee(), "A rangedAttackType melee értékének hamisnak kell lennie.");
        assertFalse(hybridAttackType.isMelee(), "A hybridAttackType melee értékének hamisnak kell lennie.");
        assertFalse(noneAttackType.isMelee(), "A noneAttackType melee értékének hamisnak kell lennie.");
    }

    @Test
    void testIsRanged() {
        assertFalse(meleeAttackType.isRanged(), "A meleeAttackType ranged értékének hamisnak kell lennie.");
        assertTrue(rangedAttackType.isRanged(), "A rangedAttackType ranged értékének igaznak kell lennie.");
        assertFalse(hybridAttackType.isRanged(), "A hybridAttackType ranged értékének hamisnak kell lennie.");
        assertFalse(noneAttackType.isRanged(), "A noneAttackType ranged értékének hamisnak kell lennie.");
    }

    @Test
    void testIsHybrid() {
        assertFalse(meleeAttackType.isHybrid(), "A meleeAttackType hybrid értékének hamisnak kell lennie.");
        assertFalse(rangedAttackType.isHybrid(), "A rangedAttackType hybrid értékének hamisnak kell lennie.");
        assertTrue(hybridAttackType.isHybrid(), "A hybridAttackType hybrid értékének igaznak kell lennie.");
        assertFalse(noneAttackType.isHybrid(), "A noneAttackType hybrid értékének hamisnak kell lennie.");
    }
}
