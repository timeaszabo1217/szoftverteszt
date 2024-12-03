package tests.Client.performanceTests.model.message;

import models.message.CardAnimation;
import models.message.GameAnimations;
import models.message.SpellAnimation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameAnimationsTest {
    private ArrayList<CardAnimation> attacks;
    private ArrayList<CardAnimation> counterAttacks;
    private ArrayList<SpellAnimation> spellAnimations;
    private GameAnimations gameAnimations;

    @BeforeEach
    void setup() {
        gameAnimations = new GameAnimations();

        attacks = new ArrayList<>();
        CardAnimation attack1 = new CardAnimation();
        CardAnimation attack2 = new CardAnimation();
        attacks.add(attack1);
        attacks.add(attack2);
        gameAnimations.getAttacks().addAll(attacks);

        counterAttacks = new ArrayList<>();
        CardAnimation counterAttack1 = new CardAnimation();
        CardAnimation counterAttack2 = new CardAnimation();
        counterAttacks.add(counterAttack1);
        counterAttacks.add(counterAttack2);
        gameAnimations.getCounterAttacks().addAll(counterAttacks);

        spellAnimations = new ArrayList<>();
        SpellAnimation spellAnimation1 = new SpellAnimation();
        SpellAnimation spellAnimation2 = new SpellAnimation();
        spellAnimations.add(spellAnimation1);
        spellAnimations.add(spellAnimation2);
        gameAnimations.getSpellAnimations().addAll(spellAnimations);
    }

    @Test
    void testGetAttacks() {
        assertEquals(attacks, gameAnimations.getAttacks());
    }

    @Test
    void testGetCounterAttacks() {
        assertEquals(counterAttacks, gameAnimations.getCounterAttacks());
    }

    @Test
    void testGetSpellAnimations() {
        assertEquals(spellAnimations, gameAnimations.getSpellAnimations());
    }
}
