package tests.Client.performanceTests.model.message;

import models.message.GameFinishMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class GameFinishMessageTest {
    private boolean youWon = false;
    private int reward = 0;
    private GameFinishMessage gameFinishMessage;

    @BeforeEach
    void setup() {
        gameFinishMessage = mock(GameFinishMessage.class);
    }

    @Test
    void testGetReward() {
        assertEquals(gameFinishMessage.getReward(), 0);
    }

    @Test
    void testAmIWinner() {
        assertEquals(gameFinishMessage.amIWinner(), false);
    }
}
