package Client.model.message;

import models.account.AccountInfo;
import models.message.LeaderBoardCopyMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;

public class LeaderBoardCopyMessageTest {

    private LeaderBoardCopyMessage leaderBoardCopyMessage;
    private AccountInfo[] mockLeaderBoard;

    @BeforeEach
    void setup() {
        leaderBoardCopyMessage = new LeaderBoardCopyMessage();
        mockLeaderBoard = new AccountInfo[]{
                mock(AccountInfo.class),
                mock(AccountInfo.class),
                mock(AccountInfo.class)
        };
    }

    @Test
    void testGetLeaderBoard() throws NoSuchFieldException, IllegalAccessException {
        var field = LeaderBoardCopyMessage.class.getDeclaredField("leaderBoard");
        field.setAccessible(true);
        field.set(leaderBoardCopyMessage, mockLeaderBoard);

        var result = leaderBoardCopyMessage.getLeaderBoard();
        assertArrayEquals(mockLeaderBoard, result);
    }
}
