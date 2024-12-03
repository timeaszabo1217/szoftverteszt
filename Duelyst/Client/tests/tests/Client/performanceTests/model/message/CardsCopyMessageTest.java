package tests.Client.performanceTests.model.message;

import models.account.Collection;
import models.message.CardsCopyMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class CardsCopyMessageTest {

    private CardsCopyMessage cardsCopyMessage;
    private Collection mockCollection;

    @BeforeEach
    void setup() {
        mockCollection = mock(Collection.class);
        cardsCopyMessage = new CardsCopyMessage();
    }

    @Test
    void testGetCards() {
        assertNull(cardsCopyMessage.getCards());
    }
}
