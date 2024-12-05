package Client.model.card.spell;

import models.card.spell.AvailabilityType;
import models.card.spell.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerTest {

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner(true, false);
    }

    @Test
    void testIsOnPut() {
        assertTrue(owner.isOwn(), "Az onPut értékének igaznak kell lennie.");
    }

    @Test
    void testIsOnAttack() {
        assertFalse(owner.isEnemy(), "Az onAttack értékének hamisnak kell lennie.");
    }
}
