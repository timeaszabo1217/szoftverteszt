package Client.model.account;

import models.account.MatchHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchHistoryTest {

    private MatchHistory matchHistory;

    @BeforeEach
    public void setUp() {
        matchHistory = new MatchHistory();
    }

    @Test
    public void testGetOppName() {
        setField(matchHistory, "oppName", "OpponentName");

        assertEquals("OpponentName", matchHistory.getOppName());
    }

    @Test
    public void testGetDate() {
        setField(matchHistory, "date", "2024-11-14");

        assertEquals("2024-11-14", matchHistory.getDate());
    }

    @Test
    public void testAmIWinner() {
        setField(matchHistory, "amIWinner", true);

        assertTrue(matchHistory.amIWinner());

        setField(matchHistory, "amIWinner", false);

        assertFalse(matchHistory.amIWinner());
    }

    private void setField(Object target, String fieldName, Object value) {
        try {
            var field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
