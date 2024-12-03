package tests.Client.performanceTests.model.game;

import models.game.CellEffect;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CellEffectTest {
    private CellEffect positiveEffect;
    private CellEffect negativeEffect;

    @BeforeEach
    void setup() {
        positiveEffect = new CellEffect(3, 5, true);
        negativeEffect = new CellEffect(7, 2, false);
    }

    @Test
    void testGetPosition() {
        Position positivePosition = positiveEffect.getPosition();
        assertEquals(3, positivePosition.getRow());
        assertEquals(5, positivePosition.getColumn());

        Position negativePosition = negativeEffect.getPosition();
        assertEquals(7, negativePosition.getRow());
        assertEquals(2, negativePosition.getColumn());
    }

    @Test
    void testIsPositive() {
        assertTrue(positiveEffect.isPositive());
        assertFalse(negativeEffect.isPositive());
    }
}
