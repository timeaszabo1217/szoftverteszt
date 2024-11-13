package tests.Client.performanceTests.model.compressedData;

import models.comperessedData.CompressedCell;
import models.comperessedData.CompressedCard;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CompressedCellTest {

    private CompressedCell compressedCell;
    private CompressedCard mockItem;

    @BeforeEach
    void setUp() {
        mockItem = mock(CompressedCard.class);
        compressedCell = new CompressedCell(2, 3, mockItem, 1);
    }

    private Object getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }

    @Test
    void testConstructorFields() throws NoSuchFieldException, IllegalAccessException {
        assertEquals(2, getPrivateField(compressedCell, "row"), "A row mező értéke 2 kell, hogy legyen.");
        assertEquals(3, getPrivateField(compressedCell, "column"), "A column mező értéke 3 kell, hogy legyen.");
        assertEquals(mockItem, getPrivateField(compressedCell, "item"), "Az item mező értéke a mockItem objektum kell, hogy legyen.");
        assertEquals(1, getPrivateField(compressedCell, "numberOfFlags"), "A numberOfFlags mező értéke 1 kell, hogy legyen.");
    }

    @Test
    void testGetters() {
        assertEquals(2, compressedCell.getRow(), "A getRow() visszaadott értéke 2 kell, hogy legyen.");
        assertEquals(3, compressedCell.getColumn(), "A getColumn() visszaadott értéke 3 kell, hogy legyen.");
        assertEquals(mockItem, compressedCell.getItem(), "A getItem() visszaadott értéke a mockItem objektum kell, hogy legyen.");
        assertEquals(1, compressedCell.getNumberOfFlags(), "A getNumberOfFlags() visszaadott értéke 1 kell, hogy legyen.");
    }

    @Test
    void testAddNumberOfFlags() {
        compressedCell.addNumberOfFlags(2);
        assertEquals(3, compressedCell.getNumberOfFlags(), "A numberOfFlags értéke 3 kell, hogy legyen az addNumberOfFlags(2) hívás után.");
    }

    @Test
    void testRemoveFlags() {
        compressedCell.removeFlags();
        assertEquals(0, compressedCell.getNumberOfFlags(), "A removeFlags() után a numberOfFlags értékének 0-nak kell lennie.");
    }

    @Test
    void testRemoveItem() {
        compressedCell.removeItem();
        assertNull(compressedCell.getItem(), "A removeItem() után az item értékének null-nak kell lennie.");
    }

    @Test
    void testManhattanDistance() {
        CompressedCell otherCell = new CompressedCell(5, 6, mockItem, 0);
        assertEquals(6, compressedCell.manhattanDistance(otherCell), "A két cella Manhattan-távolsága 6 kell, hogy legyen.");
    }

    @Test
    void testToPosition() {
        Position position = compressedCell.toPosition();
        assertEquals(2, position.getRow(), "A toPosition() visszaadott Position objektum row értéke 2 kell, hogy legyen.");
        assertEquals(3, position.getColumn(), "A toPosition() visszaadott Position objektum column értéke 3 kell, hogy legyen.");
    }
}
