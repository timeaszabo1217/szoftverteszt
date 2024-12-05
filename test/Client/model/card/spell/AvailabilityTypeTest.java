package Client.model.card.spell;

import models.card.spell.AvailabilityType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AvailabilityTypeTest {

    private AvailabilityType availabilityType;

    @BeforeEach
    void setUp() {
        availabilityType = new AvailabilityType(true, false, true, false, true, false, true);
    }

    @Test
    void testIsOnPut() {
        assertTrue(availabilityType.isOnPut(), "Az onPut értékének igaznak kell lennie.");
    }

    @Test
    void testIsOnAttack() {
        assertFalse(availabilityType.isOnAttack(), "Az onAttack értékének hamisnak kell lennie.");
    }

    @Test
    void testIsOnDeath() {
        assertTrue(availabilityType.isOnDeath(), "Az onDeath értékének igaznak kell lennie.");
    }

    @Test
    void testIsContinuous() {
        assertFalse(availabilityType.isContinuous(), "A continuous értékének hamisnak kell lennie.");
    }

    @Test
    void testIsSpecialPower() {
        assertTrue(availabilityType.isSpecialPower(), "A specialPower értékének igaznak kell lennie.");
    }

    @Test
    void testIsOnDefend() {
        assertTrue(availabilityType.isOnDefend(), "Az onDefend értékének igaznak kell lennie.");
    }
}
