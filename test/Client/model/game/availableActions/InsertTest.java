package Client.model.game.availableActions;

import models.comperessedData.CompressedCard;
import models.game.availableActions.Insert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class InsertTest {
    private CompressedCard card;
    private Insert insert;

    @BeforeEach
    void setup() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        card = mock(CompressedCard.class);

        Constructor<Insert> insertConstructor = Insert.class.getDeclaredConstructor(CompressedCard.class);
        insertConstructor.setAccessible(true);
        insert = insertConstructor.newInstance(card);
    }

    @Test
    void testgetCard() {
        var cardtesting = insert.getCard();
        assertEquals(cardtesting, card);
    }
}
