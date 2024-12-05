package Client.model.game.availableActions;

import models.comperessedData.CompressedTroop;
import models.game.availableActions.Attack;
import models.game.availableActions.Combo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ComboTest {
    private CompressedTroop attacker1;
    private CompressedTroop attacker2;
    private CompressedTroop defender;
    private Combo combo;

    @BeforeEach
    void setUp() throws NoSuchMethodException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
        attacker1 = mock(CompressedTroop.class);
        attacker2 = mock(CompressedTroop.class);
        defender = mock(CompressedTroop.class);

        var attackers = new ArrayList<>();
        attackers.add(attacker1);
        attackers.add(attacker2);

        Constructor<Combo> constructor = Combo.class.getDeclaredConstructor(ArrayList.class, CompressedTroop.class);
        constructor.setAccessible(true);
        combo = constructor.newInstance(attackers, defender);
    }

    @Test
    void testGetDefenderTroop() {
        assertEquals(defender, combo.getDefenderTroop());
    }

    @Test
    void testGetAttackers() {
        List<CompressedTroop> attackers = combo.getAttackers();

        assertEquals(2, attackers.size());
        assertTrue(attackers.contains(attacker1));
        assertTrue(attackers.contains(attacker2));
    }
}
