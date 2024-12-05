package Client.controller;

import controller.GameResultController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameResultControllerTest {

    private GameResultController gameResultController;

    @BeforeEach
    void setup() {
        gameResultController = GameResultController.getInstance();
    }

    @Test
    void testSingletonInstance() {
        GameResultController instance1 = GameResultController.getInstance();
        GameResultController instance2 = GameResultController.getInstance();

        assertEquals(instance1, instance2);
    }

    @Test
    void testSetWinnerInfo() throws NoSuchFieldException, IllegalAccessException {
        gameResultController.setWinnerInfo(true, 100);

        Field winnerField = GameResultController.class.getDeclaredField("amIWinner");
        Field rewardField = GameResultController.class.getDeclaredField("reward");

        winnerField.setAccessible(true);
        rewardField.setAccessible(true);

        boolean winner = (boolean) winnerField.get(gameResultController);
        int reward = (int) rewardField.get(gameResultController);

        assertTrue(winner);
        assertEquals(100, reward);
    }

    @Test
    void testAmIWinner() {
        gameResultController.setWinnerInfo(true, 200);
        boolean isWinner = gameResultController.amInWinner();
        assertTrue(isWinner);
    }

    @Test
    void testGetReward() {
        gameResultController.setWinnerInfo(false, 150);
        int reward = gameResultController.getReward();
        assertEquals(150, reward);
    }
}
