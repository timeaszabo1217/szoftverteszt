package Client.model.message;

import models.card.DeckInfo;
import models.message.StoriesCopyMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;

public class StoriesCopyMessageTest {
    private StoriesCopyMessage storiesCopyMessage;
    private DeckInfo[] mockStories;

    @BeforeEach
    void setup() {
        storiesCopyMessage = new StoriesCopyMessage();
        mockStories = new DeckInfo[]{
                mock(DeckInfo.class),
                mock(DeckInfo.class)
        };

        try {
            var field = StoriesCopyMessage.class.getDeclaredField("stories");
            field.setAccessible(true);
            field.set(storiesCopyMessage, mockStories);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetStories() {
        assertArrayEquals(mockStories, storiesCopyMessage.getStories());
    }
}
