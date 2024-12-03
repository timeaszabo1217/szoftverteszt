package tests.Client.performanceTests.model.game;

import models.card.Deck;
import models.card.TempDeck;
import models.game.GameType;
import models.game.Story;
import models.game.TempStory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TempStoryTest {
    private Story mockStory;
    private TempDeck tempDeck;
    private Deck mockDeck;
    private GameType mockGameType;
    private int reward = 0;
    private TempStory tempStory;

    @BeforeEach
    void setup() {
        mockStory = mock(Story.class);
        mockDeck = mock(Deck.class);
        mockGameType = mock(GameType.class);

        when(mockStory.getDeck()).thenReturn(mockDeck);
        when(mockStory.getGameType()).thenReturn(mockGameType);
        when(mockStory.getReward()).thenReturn(reward);

        tempDeck = new TempDeck(mockDeck);

        tempStory = new TempStory(mockStory);
    }

    @Test
    void testConstructor() {
        assertEquals(tempDeck.getClass(), tempStory.getDeck().getClass());
    }

    @Test
    void testGetDeck() {
        TempDeck deck = tempStory.getDeck();
        assertEquals(tempDeck.getClass(), deck.getClass());
    }

    @Test
    void testGetGameType() {
        GameType gameType = tempStory.getGameType();
        assertEquals(mockGameType, gameType);
    }

    @Test
    void testGetReward() {
        int rewardValue = tempStory.getReward();
        assertEquals(reward, rewardValue);
    }
}
