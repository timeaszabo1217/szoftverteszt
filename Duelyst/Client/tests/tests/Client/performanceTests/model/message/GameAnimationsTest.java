package tests.Client.performanceTests.model.message;

import models.card.spell.Spell;
import models.game.availableActions.Attack;
import models.message.CardAnimation;
import models.message.GameAnimations;
import models.message.SpellAnimation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

public class GameAnimationsTest {
    private ArrayList<CardAnimation> attacks;
    private ArrayList<CardAnimation> counterAttacks;
    private ArrayList<SpellAnimation> spellAnimations;
    private GameAnimations gameAnimations;

    @BeforeEach
    void setup() {
        CardAnimation cardAnimation1 = mock(CardAnimation.class);
        CardAnimation cardAnimation2 = mock(CardAnimation.class);

        attacks = new ArrayList<>();
        attacks.add(cardAnimation1);
        attacks.add(cardAnimation2);

        counterAttacks = new ArrayList<>();
        counterAttacks.add(cardAnimation1);
        counterAttacks.add(cardAnimation2);

        SpellAnimation spellAnimation1 = mock(SpellAnimation.class);
        SpellAnimation spellAnimation2 = mock(SpellAnimation.class);
        spellAnimations = new ArrayList<>();

        spellAnimations.add(spellAnimation1);
        spellAnimations.add(spellAnimation2);

        gameAnimations = mock(GameAnimations.class);
    }

    @Test
    void testGetAttacks() {
        assertEquals(gameAnimations.getAttacks(), new ArrayList<CardAnimation>());
    }

    @Test
    void testGetCounterAttacks() {
        assertEquals(gameAnimations.getCounterAttacks(), new ArrayList<CardAnimation>());
    }

    @Test
    void testGetSpellAnimations() {
        assertEquals(gameAnimations.getSpellAnimations(), new ArrayList<SpellAnimation>());
    }
}
