package tests.Client.performanceTests.model.message;

import models.message.GameUpdateMessage;
import models.game.CellEffect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameUpdateMessageTest {

    private GameUpdateMessage message;

    @BeforeEach
    public void setUp() {
        message = new GameUpdateMessage();

        setField(message, "turnNumber", 10);
        setField(message, "player1CurrentMP", 5);
        setField(message, "player1NumberOfCollectedFlags", 3);
        setField(message, "player2CurrentMP", 7);
        setField(message, "player2NumberOfCollectedFlags", 4);
        setField(message, "cellEffects", new CellEffect[] { new CellEffect(5,5,true), new CellEffect(6,6, false) });
    }

    @Test
    public void testTurnNumber() {
        assertEquals(10, message.getTurnNumber(), "Turn number should be 10.");
    }

    @Test
    public void testPlayer1CurrentMP() {
        assertEquals(5, message.getPlayer1CurrentMP(), "Player 1's current MP should be 5.");
    }

    @Test
    public void testPlayer1NumberOfCollectedFlags() {
        assertEquals(3, message.getPlayer1NumberOfCollectedFlags(), "Player 1's collected flags should be 3.");
    }

    @Test
    public void testPlayer2CurrentMP() {
        assertEquals(7, message.getPlayer2CurrentMP(), "Player 2's current MP should be 7.");
    }

    @Test
    public void testPlayer2NumberOfCollectedFlags() {
        assertEquals(4, message.getPlayer2NumberOfCollectedFlags(), "Player 2's collected flags should be 4.");
    }

    @Test
    public void testCellEffects() {
        CellEffect[] cellEffects = message.getCellEffects();
        assertNotNull(cellEffects, "Cell effects should not be null.");
        assertEquals(2, cellEffects.length, "There should be 2 cell effects.");
        assertEquals(5, cellEffects[0].getPosition().getRow(), "First cell effect should be 'Fire'.");
        assertEquals(6, cellEffects[1].getPosition().getRow(), "Second cell effect should be 'Ice'.");
    }

    private void setField(Object target, String fieldName, Object value) {
        try {
            var field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            fail("Failed to set field value for " + fieldName);
        }
    }
}
