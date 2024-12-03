package tests.Client.performanceTests.model.game;

import models.card.Deck;
import models.game.GameType;
import models.game.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class StoryTest {
    private Deck deck;
    private GameType gameType;
    private int reward = 0;
    private Story story;

    @BeforeEach
    void setup() {
        deck = mock(Deck.class);
        gameType = mock(GameType.class);

        story = new Story(deck, gameType, reward);
    }

    @Test
    void testGetDeck() {
        var getdeck = story.getDeck();

        assertEquals(getdeck, deck);
    }

    @Test
    void testGetGameType() {
        var getgametype = story.getGameType();

        assertEquals(getgametype, gameType);
    }

    @Test
    void testGetReward() throws Exception {
        Method getReward = Story.class.getDeclaredMethod("getReward");
        getReward.setAccessible(true);

        int actualReward = (int) getReward.invoke(story);

        assertEquals(reward, actualReward);
    }
}
