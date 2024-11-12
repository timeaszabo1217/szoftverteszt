package tests.Client.performanceTests;

import models.card.Card;
import models.card.Deck;
import models.card.DeckInfo;
import models.game.GameType;
import models.game.Story;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasicDeckInfoTest {

    @Test
    public void testDeckInfoCreationWithStory() {
        Card mockHeroCard = mock(Card.class);
        when(mockHeroCard.getName()).thenReturn("HeroName"); // Hero név beállítása

        Deck mockDeck = mock(Deck.class);
        when(mockDeck.getName()).thenReturn("starterDeck");
        when(mockDeck.getHero()).thenReturn(mockHeroCard);

        Story mockStory = mock(Story.class);
        when(mockStory.getDeck()).thenReturn(mockDeck);
        when(mockStory.getGameType()).thenReturn(GameType.KILL_HERO);

        DeckInfo deck = new DeckInfo(mockStory);
        assertEquals("starterDeck", deck.getDeckName(), "Deck name should be set correctly.");
        assertEquals("HeroName", deck.getHeroName(), "Hero name should be set correctly.");
        assertEquals(GameType.KILL_HERO, deck.getType(), "Game type should be set correctly.");
    }
}
