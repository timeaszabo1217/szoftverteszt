package Client.model.message;

import models.Constants;
import models.message.ChangeCardNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeCardNumberTest {

    private ChangeCardNumber changeCardNumber;
    private String cardName;
    private int number;

    @BeforeEach
    void setup() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        cardName = "testCard";
        number = 5;

        Constructor<ChangeCardNumber> constructor = ChangeCardNumber.class.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        changeCardNumber = constructor.newInstance(cardName, number);
    }

    @Test
    void testGetCardName() {
        var result = changeCardNumber.getCardName();
        assertEquals(cardName, result);
    }

    @Test
    void testGetNumber() {
        var result = changeCardNumber.getNumber();
        assertEquals(number, result);
    }
}
