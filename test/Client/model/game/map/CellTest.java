package Client.model.game.map;

import models.card.Card;
import models.game.map.Cell;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CellTest {
    private int row = 0;
    private int column = 0;
    private List<Card> items;
    private Card card1;
    private Card card2;
    private Cell cell;

    @BeforeEach
    void setup() {
        cell = new Cell(row, column);

        card1 = mock(Card.class);
        card2 = mock(Card.class);

        items = new ArrayList<>();
        items.add(card1);
        items.add(card2);

        cell.addItem(card1);
        cell.addItem(card2);
    }

    @Test
    void testGetRow() {
        var getrow = cell.getRow();
        assertEquals(row, getrow);
    }

    @Test
    void testGetColumn() {
        var getcolumn = cell.getColumn();
        assertEquals(column, getcolumn);
    }

    @Test
    void testGetItems() {
        var getitems = cell.getItems();
        assertEquals(items, getitems);
    }

    @Test
    void testAddItem() {
        Card card = mock(Card.class);
        cell.addItem(card);
        assertEquals(3, cell.getItems().size());
        assertTrue(cell.getItems().contains(card));
    }

    @Test
    void testClearItems() {
        cell.clearItems();
        assertTrue(cell.getItems().isEmpty());
    }

    @Test
    void testIsNextTo() {
        Cell adjacentCell = new Cell(row + 1, column);
        assertTrue(cell.isNextTo(adjacentCell));

        Cell nonAdjacentCell = new Cell(row + 3, column);
        assertFalse(cell.isNextTo(nonAdjacentCell));
    }

    @Test
    void testManhattanDistanceWithCell() {
        Cell targetCell = new Cell(2, 2);
        int distance = cell.manhattanDistance(targetCell);
        assertEquals(4, distance);
    }

    @Test
    void testManhattanDistanceWithPosition() {
        Position position = new Position(3, 3);
        int distance = cell.manhattanDistance(position);
        assertEquals(6, distance);
    }

    @Test
    void testManhattanDistanceWithCoordinates() {
        int distance = cell.manhattanDistance(1, 2);
        assertEquals(3, distance);
    }

    @Test
    void testEquals() {
        Cell sameCell = new Cell(row, column);
        assertTrue(cell.equals(sameCell));

        Cell differentCell = new Cell(row + 1, column);
        assertFalse(cell.equals(differentCell));
    }
}
