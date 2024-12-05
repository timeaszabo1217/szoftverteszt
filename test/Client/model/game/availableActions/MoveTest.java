package Client.model.game.availableActions;

import models.comperessedData.CompressedTroop;
import models.game.availableActions.Move;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MoveTest {
    private CompressedTroop troop;
    private List<Position> positions;
    private Position pos1;
    private Position pos2;
    private Move move;

    @BeforeEach
    void setup() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        troop = mock(CompressedTroop.class);
        pos1 = mock(Position.class);
        pos2 = mock(Position.class);

        positions = new ArrayList<>();
        positions.add(pos1);
        positions.add(pos2);

        Constructor<Move> moveConstructor = Move.class.getDeclaredConstructor(CompressedTroop.class, ArrayList.class);
        moveConstructor.setAccessible(true);
        move = moveConstructor.newInstance(troop, positions);
    }

    @Test
    void testGetTroop() {
        var trooper = move.getTroop();
        assertEquals(trooper, troop);
    }

    @Test
    void testGetTargets() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        var method = Move.class.getDeclaredMethod("getTargets");
        method.setAccessible(true);

        @SuppressWarnings("unchecked")
        List<Position> targets = (List<Position>) method.invoke(move);

        assertEquals(positions, targets);
        assertEquals(2, targets.size());
        assertEquals(pos1, targets.get(0));
        assertEquals(pos2, targets.get(1));
    }
}
