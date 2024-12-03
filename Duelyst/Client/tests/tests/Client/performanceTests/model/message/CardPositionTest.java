package tests.Client.performanceTests.model.message;

import models.message.CardPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardPositionTest {

    @Test
    void testCardPositionValues() {
        CardPosition[] positions = CardPosition.values();
        assertNotNull(positions);
        assertEquals(5, positions.length);

        assertEquals(CardPosition.MAP, positions[0]);
        assertEquals(CardPosition.HAND, positions[1]);
        assertEquals(CardPosition.NEXT, positions[2]);
        assertEquals(CardPosition.COLLECTED, positions[3]);
        assertEquals(CardPosition.GRAVE_YARD, positions[4]);
    }

    @Test
    void testCardPositionValueOf() {
        assertEquals(CardPosition.MAP, CardPosition.valueOf("MAP"));
        assertEquals(CardPosition.HAND, CardPosition.valueOf("HAND"));
        assertEquals(CardPosition.NEXT, CardPosition.valueOf("NEXT"));
        assertEquals(CardPosition.COLLECTED, CardPosition.valueOf("COLLECTED"));
        assertEquals(CardPosition.GRAVE_YARD, CardPosition.valueOf("GRAVE_YARD"));
    }
}
