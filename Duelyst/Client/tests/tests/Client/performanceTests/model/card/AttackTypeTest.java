package tests.Client.performanceTests.model.card;

import models.account.AccountType;
import models.card.AttackType;
import models.game.availableActions.Attack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttackTypeTest {

    @Test
    public void testEnumValues() {
        AttackType[] expectedValues = {AttackType.MELEE, AttackType.RANGED, AttackType.HYBRID};
        assertArrayEquals(expectedValues, AttackType.values());
    }

    @Test
    public void testEnumValueOf() {
        assertEquals(AttackType.MELEE, AttackType.valueOf("MELEE"));
        assertEquals(AttackType.RANGED, AttackType.valueOf("RANGED"));
        assertEquals(AttackType.HYBRID, AttackType.valueOf("HYBRID"));
    }

    @Test
    public void testEnumName() {
        assertEquals("MELEE", AttackType.MELEE.name());
        assertEquals("RANGED", AttackType.RANGED.name());
        assertEquals("HYBRID", AttackType.HYBRID.name());
    }
}
