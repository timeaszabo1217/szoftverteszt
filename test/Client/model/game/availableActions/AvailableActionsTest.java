package Client.model.game.availableActions;

import models.card.AttackType;
import models.comperessedData.*;
import models.game.availableActions.*;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AvailableActionsTest {
    private AvailableActions availableActions;
    private CompressedGame mockGame;
    private CompressedPlayer mockOwnPlayer;
    private CompressedPlayer mockOtherPlayer;
    private CompressedTroop mockTroop;
    private CompressedCard mockCard;

    @BeforeEach
    void setUp() {
        availableActions = new AvailableActions();
        mockGame = mock(CompressedGame.class);
        mockOwnPlayer = mock(CompressedPlayer.class);
        mockOtherPlayer = mock(CompressedPlayer.class);
        mockTroop = mock(CompressedTroop.class);
        mockCard = mock(CompressedCard.class);

        CompressedGameMap mockGameMap = mock(CompressedGameMap.class);
        CompressedCell mockCell = mock(CompressedCell.class);

        when(mockGame.getCurrentTurnPlayer()).thenReturn(mockOwnPlayer);
        when(mockGame.getOtherTurnPlayer()).thenReturn(mockOtherPlayer);
        when(mockGame.getGameMap()).thenReturn(mockGameMap);
        when(mockGameMap.getCell(anyInt(), anyInt())).thenReturn(mockCell);
        when(mockCell.toPosition()).thenReturn(new Position(0, 0));
    }


    @Test
    void testCalculateCardInserts() {
        when(mockOwnPlayer.getHand()).thenReturn(List.of(mockCard));
        when(mockOwnPlayer.getCurrentMP()).thenReturn(5);
        when(mockCard.getMannaPoint()).thenReturn(3);

        availableActions.calculate(mockGame);

        List<Insert> handInserts = availableActions.getHandInserts();
        assertEquals(1, handInserts.size());
        assertEquals(mockCard, handInserts.get(0).getCard());
    }

    @Test
    void testCalculateAttacks() {
        when(mockOwnPlayer.getTroops()).thenReturn(List.of(mockTroop));
        when(mockOtherPlayer.getTroops()).thenReturn(List.of(mockTroop));
        when(mockTroop.canAttack()).thenReturn(true);
        when(mockTroop.getCard()).thenReturn(mockCard);
        when(mockCard.getAttackType()).thenReturn(AttackType.MELEE);
        when(mockTroop.getPosition()).thenReturn(new Position(0, 0));
        when(mockOtherPlayer.getTroops().get(0).getPosition()).thenReturn(new Position(0, 1));

        availableActions.calculate(mockGame);

        List<Attack> attacks = availableActions.getAttacks();
        assertEquals(1, attacks.size());
        assertEquals(mockTroop, attacks.get(0).getAttackerTroop());
    }

    @Test
    void testCalculateMoves() {
        when(mockOwnPlayer.getTroops()).thenReturn(List.of(mockTroop));
        when(mockTroop.canMove()).thenReturn(true);
        when(mockTroop.getPosition()).thenReturn(new Position(2, 2));

        availableActions.calculate(mockGame);

        List<Move> moves = availableActions.getMoves();
        assertEquals(1, moves.size());
        assertEquals(mockTroop, moves.get(0).getTroop());
    }

    @Test
    void testCanInsertCard() {
        when(mockOwnPlayer.getHand()).thenReturn(List.of(mockCard));
        when(mockOwnPlayer.getCurrentMP()).thenReturn(5);
        when(mockCard.getMannaPoint()).thenReturn(3);

        availableActions.calculate(mockGame);

        assertTrue(availableActions.canInsertCard(mockCard));
    }

    @Test
    void testCanMove() {
        when(mockOwnPlayer.getTroops()).thenReturn(List.of(mockTroop));
        when(mockTroop.canMove()).thenReturn(true);
        when(mockTroop.getPosition()).thenReturn(new Position(2, 2));

        availableActions.calculate(mockGame);

        assertTrue(availableActions.canMove(mockTroop, 0, 0));
    }

    @Test
    void testCanAttack() {
        when(mockOwnPlayer.getTroops()).thenReturn(List.of(mockTroop));
        when(mockOtherPlayer.getTroops()).thenReturn(List.of(mockTroop));
        when(mockTroop.canAttack()).thenReturn(true);
        when(mockTroop.getCard()).thenReturn(mockCard);
        when(mockCard.getAttackType()).thenReturn(AttackType.MELEE);
        when(mockTroop.getPosition()).thenReturn(new Position(0, 0));
        when(mockOtherPlayer.getTroops().get(0).getPosition()).thenReturn(new Position(0, 1));

        availableActions.calculate(mockGame);

        assertTrue(availableActions.canAttack(mockTroop, 0, 1));
        assertFalse(availableActions.canAttack(mockTroop, 1, 1));
    }
}
