package tests.Client.performanceTests.model.message;

import models.comperessedData.CompressedCard;
import models.message.CardPosition;
import models.message.CardPositionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CardPositionMessageTest {

    private CardPositionMessage cardPositionMessage;
    private CompressedCard mockCompressedCard;
    private CardPosition mockCardPosition;

    @BeforeEach
    void setup() {
        cardPositionMessage = new CardPositionMessage();
        mockCompressedCard = mock(CompressedCard.class);
        mockCardPosition = mock(CardPosition.class);
    }

    @Test
    void testGetCompressedCard() throws Exception {
        var field = CardPositionMessage.class.getDeclaredField("compressedCard");
        field.setAccessible(true);
        field.set(cardPositionMessage, mockCompressedCard);

        assertEquals(mockCompressedCard, cardPositionMessage.getCompressedCard());
    }

    @Test
    void testGetCardPosition() throws Exception {
        var field = CardPositionMessage.class.getDeclaredField("cardPosition");
        field.setAccessible(true);
        field.set(cardPositionMessage, mockCardPosition);

        assertEquals(mockCardPosition, cardPositionMessage.getCardPosition());
    }
}
