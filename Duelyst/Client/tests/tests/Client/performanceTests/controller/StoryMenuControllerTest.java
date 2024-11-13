package tests.Client.performanceTests.controller;

import controller.Client;
import controller.StoryMenuController;
import models.card.DeckInfo;
import models.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class StoryMenuControllerTest {
    private StoryMenuController storyMenuController;
    private Client mockClient;

    @BeforeEach
    public void setUp() throws Exception {
        storyMenuController = StoryMenuController.getInstance();
        mockClient = Mockito.mock(Client.class);

        Client.setInstance(mockClient);
    }

    @Test
    public void testStartGame() {
        int stage = 1;
        storyMenuController.startGame(stage);

        verify(mockClient).addToSendingMessagesAndSend(Mockito.any(Message.class));
    }

    @Test
    public void testSetAndGetStories() throws Exception {
        DeckInfo[] mockStories = new DeckInfo[]{Mockito.mock(DeckInfo.class)};

        Method setStoriesMethod = StoryMenuController.class.getDeclaredMethod("setStories", DeckInfo[].class);
        setStoriesMethod.setAccessible(true);
        setStoriesMethod.invoke(storyMenuController, (Object) mockStories);

        assertEquals(mockStories, storyMenuController.getStories());
    }
}
