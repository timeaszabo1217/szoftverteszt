package Client.model.game.availableActions;

import models.comperessedData.CompressedTroop;
import models.game.availableActions.Attack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AttackTest {

    private CompressedTroop mockAttackerTroop;
    private CompressedTroop mockDefender1;
    private CompressedTroop mockDefender2;
    private Attack attack;

    @BeforeEach
    void setUp() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        mockAttackerTroop = mock(CompressedTroop.class);
        mockDefender1 = mock(CompressedTroop.class);
        mockDefender2 = mock(CompressedTroop.class);

        ArrayList<CompressedTroop> defenders = new ArrayList<>();
        defenders.add(mockDefender1);
        defenders.add(mockDefender2);

        Constructor<Attack> constructor = Attack.class.getDeclaredConstructor(CompressedTroop.class, ArrayList.class);
        constructor.setAccessible(true);
        attack = constructor.newInstance(mockAttackerTroop, defenders);
    }

    @Test
    void testGetAttackerTroop() {
        assertEquals(mockAttackerTroop, attack.getAttackerTroop(),"Az attackerTroop-nak meg kell egyeznie a mockolt támadóval.");
    }

    @Test
    void testGetDefenders() {
        List<CompressedTroop> defenders = attack.getDefenders();

        assertEquals(2, defenders.size(), "A defenders lista méretének 2-nek kell lennie.");
        assertTrue(defenders.contains(mockDefender1), "A defenders listának tartalmaznia kell mockDefender1-et.");
        assertTrue(defenders.contains(mockDefender2), "A defenders listának tartalmaznia kell mockDefender2-t.");
    }
}
