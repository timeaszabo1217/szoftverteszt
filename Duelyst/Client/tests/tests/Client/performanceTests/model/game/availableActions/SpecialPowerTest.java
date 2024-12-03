package tests.Client.performanceTests.model.game.availableActions;

import models.Constants;
import models.comperessedData.CompressedCard;
import models.comperessedData.CompressedTroop;
import models.game.availableActions.SpecialPower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SpecialPowerTest {
    private CompressedTroop hero;
    private SpecialPower specialPower;

    @BeforeEach
    void setup() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        hero = mock(CompressedTroop.class);

        Constructor<SpecialPower> constructor = SpecialPower.class.getDeclaredConstructor(CompressedTroop.class);
        constructor.setAccessible(true);
        specialPower = constructor.newInstance(hero);
    }

    @Test
    void testGetHero() {
        var getHero = specialPower.getHero();
        assertEquals(getHero, hero);
    }
}
