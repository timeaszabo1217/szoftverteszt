package tests.Client.performanceTests.model.message;

import models.message.CardAnimation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class CardAnimationTest {

    private CardAnimation cardAnimation;

    @BeforeEach
    void setup() {
        cardAnimation = new CardAnimation();
    }

    @Test
    void testGetDefender() {
        assertNull(cardAnimation.getDefender());
    }

    @Test
    void testGetAttacker() {
        assertNull(cardAnimation.getAttacker());
    }
}
