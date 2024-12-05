package Client.model.message;

import models.comperessedData.CompressedGame;
import models.comperessedData.CompressedPlayer;
import models.game.GameType;
import models.message.OnlineGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OnlineGameTest {
    private String player1 = "ez";
    private String player2 = "az";
    private GameType gameType;
    private OnlineGame onlineGame;

    private CompressedGame compressedGame;
    private CompressedPlayer compressedPlayer1;
    private CompressedPlayer compressedPlayer2;

    @BeforeEach
    void setup() {
        compressedGame = mock(CompressedGame.class);
        compressedPlayer1 = mock(CompressedPlayer.class);
        compressedPlayer2 = mock(CompressedPlayer.class);

        when(compressedGame.getPlayerOne()).thenReturn(compressedPlayer1);
        when(compressedGame.getPlayerTwo()).thenReturn(compressedPlayer2);
        when(compressedPlayer1.getUserName()).thenReturn(player1);
        when(compressedPlayer2.getUserName()).thenReturn(player2);

        onlineGame = new OnlineGame(compressedGame);
    }

    @Test
    void testGetPlayer1() {
        assertEquals(player1, onlineGame.getPlayer1());
    }

    @Test
    void testGetPlayer2() {
        assertEquals(player2, onlineGame.getPlayer2());
    }

    @Test
    void testGetGameType() {
        when(compressedGame.getGameType()).thenReturn(gameType);
        assertEquals(gameType, onlineGame.getGameType());
    }
}
