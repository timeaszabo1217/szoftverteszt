package Client.model.game.map;

import models.comperessedData.CompressedCell;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(3, 5);
    }

    @Test
    void testGetRow() {
        assertEquals(3, position.getRow());
    }

    @Test
    void testGetColumn() {
        assertEquals(5, position.getColumn());
    }

    @Test
    void testEquals() {
        Position samePosition = new Position(3, 5);
        Position differentPosition = new Position(4, 6);

        assertTrue(position.equals(samePosition));
        assertFalse(position.equals(differentPosition));
    }

    @Test
    void testManhattanDistanceWithPosition() {
        Position targetPosition = new Position(6, 8);
        int distance = position.manhattanDistance(targetPosition);
        assertEquals(6, distance);
    }

    @Test
    void testManhattanDistanceWithCompressedCell() {
        CompressedCell cell = mock(CompressedCell.class);
        when(cell.getRow()).thenReturn(1);
        when(cell.getColumn()).thenReturn(4);

        int distance = position.manhattanDistance(cell);
        assertEquals(3, distance);
    }

    @Test
    void testManhattanDistanceWithCoordinates() {
        int distance = position.manhattanDistance(7, 2);
        assertEquals(7, distance);
    }

    @Test
    void testIsNextTo() {
        Position adjacentPosition = new Position(4, 6);
        Position nonAdjacentPosition = new Position(6, 8);

        assertTrue(position.isNextTo(adjacentPosition));
        assertFalse(position.isNextTo(nonAdjacentPosition));
    }

    @Test
    void testToString() {
        assertEquals("(3, 5)", position.toString());
    }
}
