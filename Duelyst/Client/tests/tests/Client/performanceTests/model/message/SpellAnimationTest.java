package tests.Client.performanceTests.model.message;

import models.card.spell.AvailabilityType;
import models.game.map.Position;
import models.message.SpellAnimation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class SpellAnimationTest {
    private Set<Position> positions;
    private AvailabilityType availabilityType;
    private SpellAnimation spellAnimation;

    @BeforeEach
    void setup() {
        Position pos1 = mock(Position.class);
        Position pos2 = mock(Position.class);

        positions = new HashSet<>();
        positions.add(pos1);
        positions.add(pos2);

        availabilityType = mock(AvailabilityType.class);
        spellAnimation = mock(SpellAnimation.class);
    }

    @Test
    void testGetPositions() {
        assertEquals(spellAnimation.getPositions(), new HashSet<>());
    }

    @Test
    void testGetAvailabilityType() {
        assertNull(spellAnimation.getAvailabilityType());
    }
}
