package Client.model.game;

import models.game.GameType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameTypeTest {

    @Test
    void testGameTypeValues() {
        GameType[] gameTypes = GameType.values();
        assertNotNull(gameTypes, "A GameType enum értékei nem lehetnek nullák.");
        assertEquals(3, gameTypes.length);
        assertEquals(GameType.KILL_HERO, gameTypes[0]);
        assertEquals(GameType.A_FLAG, gameTypes[1]);
        assertEquals(GameType.SOME_FLAG, gameTypes[2]);
    }

    @Test
    void testValueOf() {
        assertEquals(GameType.KILL_HERO, GameType.valueOf("KILL_HERO"));
        assertEquals(GameType.A_FLAG, GameType.valueOf("A_FLAG"));
        assertEquals(GameType.SOME_FLAG, GameType.valueOf("SOME_FLAG"));
    }
}
