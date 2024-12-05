package Client.model.message;

import models.account.AccountInfo;
import models.game.GameType;
import models.message.OnlineGame;
import models.message.OpponentInfoMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class OpponentInfoMessageTest {
    private AccountInfo opponentInfo;
    private OpponentInfoMessage opponentInfoMessage;

    @BeforeEach
    void setup() {
        opponentInfo = mock(AccountInfo.class);
        opponentInfoMessage = new OpponentInfoMessage();
    }

    @Test
    void testGetOpponentInfo() {
        assertNull(opponentInfoMessage.getOpponentInfo());
    }
}
