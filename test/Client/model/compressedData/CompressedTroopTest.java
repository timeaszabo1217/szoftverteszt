package Client.model.compressedData;

import models.comperessedData.CompressedCard;
import models.comperessedData.CompressedTroop;
import models.game.map.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CompressedTroopTest {

    private CompressedTroop compressedTroop;
    private CompressedCard mockCard;
    private Position mockPosition;

    @BeforeEach
    void setUp() {
        mockCard = mock(CompressedCard.class);
        mockPosition = mock(Position.class);

        compressedTroop = new CompressedTroop(
                mockCard,
                10,
                20,
                5,
                mockPosition,
                true,
                true,
                false,
                true,
                3,
                1
        );
    }

    @Test
    void testConstructorFields() {
        assertEquals(mockCard, compressedTroop.getCard(), "A card mező értékének a mockCard objektumnak kell lennie.");
        assertEquals(10, compressedTroop.getCurrentAp(), "A currentAp értéke 10 kell, hogy legyen.");
        assertEquals(20, compressedTroop.getCurrentHp(), "A currentHp értéke 20 kell, hogy legyen.");
        assertEquals(5, compressedTroop.getEnemyHitChanges(), "Az enemyHitChanges értéke 5 kell, hogy legyen.");
        assertEquals(mockPosition, compressedTroop.getPosition(), "A position mező értékének a mockPosition objektumnak kell lennie.");
        assertTrue(compressedTroop.canMove(), "A canMove értéke true kell, hogy legyen.");
        assertTrue(compressedTroop.canAttack(), "A canAttack értéke true kell, hogy legyen.");
        assertFalse(compressedTroop.isDisarm(), "Az isDisarm értéke false kell, hogy legyen.");
        assertTrue(compressedTroop.isNoAttackFromWeakerOnes(), "A noAttackFromWeakerOnes értéke true kell, hogy legyen.");
        assertEquals(3, compressedTroop.getNumberOfCollectedFlags(), "A numberOfCollectedFlags értéke 3 kell, hogy legyen.");
        assertEquals(1, compressedTroop.getPlayerNumber(), "A playerNumber értéke 1 kell, hogy legyen.");
    }

    @Test
    void testCopyConstructor() {
        CompressedTroop copyTroop = new CompressedTroop(compressedTroop, 2, 3);

        assertEquals(mockCard, copyTroop.getCard(), "A másolt troop card mezőjének egyeznie kell az eredetivel.");
        assertEquals(10, copyTroop.getCurrentAp(), "A másolt troop currentAp mezőjének egyeznie kell az eredetivel.");
        assertEquals(20, copyTroop.getCurrentHp(), "A másolt troop currentHp mezőjének egyeznie kell az eredetivel.");
        assertEquals(5, copyTroop.getEnemyHitChanges(), "A másolt troop enemyHitChanges mezőjének egyeznie kell az eredetivel.");
        assertEquals(new Position(2, 3), copyTroop.getPosition(), "A másolt troop position mezőjének új értékeket kell kapnia (2, 3).");
        assertTrue(copyTroop.canMove(), "A másolt troop canMove mezőjének egyeznie kell az eredetivel.");
        assertTrue(copyTroop.canAttack(), "A másolt troop canAttack mezőjének egyeznie kell az eredetivel.");
        assertFalse(copyTroop.isDisarm(), "A másolt troop isDisarm mezőjének egyeznie kell az eredetivel.");
        assertTrue(copyTroop.isNoAttackFromWeakerOnes(), "A másolt troop noAttackFromWeakerOnes mezőjének egyeznie kell az eredetivel.");
        assertEquals(3, copyTroop.getNumberOfCollectedFlags(), "A másolt troop numberOfCollectedFlags mezőjének egyeznie kell az eredetivel.");
        assertEquals(1, copyTroop.getPlayerNumber(), "A másolt troop playerNumber mezőjének egyeznie kell az eredetivel.");
    }
}
