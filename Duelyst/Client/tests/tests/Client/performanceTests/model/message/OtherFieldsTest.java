package tests.Client.performanceTests.model.message;

import models.game.map.Position;
import models.message.OtherFields;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OtherFieldsTest {

    private OtherFields otherFields;

    @BeforeEach
    void setup() {
        otherFields = new OtherFields();
    }

    @Test
    void testSetDeckName() throws NoSuchFieldException, IllegalAccessException {
        String deckName = "MyDeck";

        Field field = OtherFields.class.getDeclaredField("deckName");
        field.setAccessible(true);

        otherFields.setDeckName(deckName);

        assertEquals(deckName, field.get(otherFields));
    }

    @Test
    void testSetCardName() throws NoSuchFieldException, IllegalAccessException {
        String cardName = "MyCard";

        Field field = OtherFields.class.getDeclaredField("cardName");
        field.setAccessible(true);

        otherFields.setCardName(cardName);

        assertEquals(cardName, field.get(otherFields));
    }

    @Test
    void testSetMyCardId() throws NoSuchFieldException, IllegalAccessException {
        String myCardId = "Card123";

        Field field = OtherFields.class.getDeclaredField("myCardId");
        field.setAccessible(true);

        otherFields.setMyCardId(myCardId);

        assertEquals(myCardId, field.get(otherFields));
    }

    @Test
    void testSetOpponentCardId() throws NoSuchFieldException, IllegalAccessException {
        String opponentCardId = "Opponent456";

        Field field = OtherFields.class.getDeclaredField("opponentCardId");
        field.setAccessible(true);

        otherFields.setOpponentCardId(opponentCardId);

        assertEquals(opponentCardId, field.get(otherFields));
    }

    @Test
    void testSetMyCardIds() throws NoSuchFieldException, IllegalAccessException {
        String[] myCardIds = {"Card1", "Card2", "Card3"};

        Field field = OtherFields.class.getDeclaredField("myCardIds");
        field.setAccessible(true);

        otherFields.setMyCardIds(myCardIds);

        assertArrayEquals(myCardIds, (String[]) field.get(otherFields));
    }

    @Test
    void testSetPosition() throws NoSuchFieldException, IllegalAccessException {
        Position position = new Position(1, 2);

        Field field = OtherFields.class.getDeclaredField("position");
        field.setAccessible(true);

        otherFields.setPosition(position);

        assertEquals(position, field.get(otherFields));
    }

    @Test
    void testSetSudoCommand() throws NoSuchFieldException, IllegalAccessException {
        String sudoCommand = "sudo-reboot";

        Field field = OtherFields.class.getDeclaredField("sudoCommand");
        field.setAccessible(true);

        otherFields.setSudoCommand(sudoCommand);

        assertEquals(sudoCommand, field.get(otherFields));
    }
}
