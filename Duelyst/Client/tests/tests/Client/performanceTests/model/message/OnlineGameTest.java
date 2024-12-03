package tests.Client.performanceTests.model.message;

import models.game.GameType;
import models.message.GameAnimations;
import models.message.OnlineGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class OnlineGameTest {
    private String player1 = "az";
    private String player2 = "ez";
    private GameType gameType;
    private OnlineGame onlineGame;

    @BeforeEach
    void setup() {
        gameType = mock(GameType.class);
        onlineGame = mock(OnlineGame.class);
    }

    @Test
    void testGetPlayer1() {
        assertNull(onlineGame.getPlayer1());
    }

    @Test
    void testGetPlayer2() {
        assertNull(onlineGame.getPlayer2());
    }

    @Test
    void testGetGameType() {
        assertNull(onlineGame.getGameType());
    }
}
