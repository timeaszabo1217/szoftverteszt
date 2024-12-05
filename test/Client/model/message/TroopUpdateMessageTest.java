package Client.model.message;

import models.comperessedData.CompressedTroop;
import models.message.TroopUpdateMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TroopUpdateMessageTest {
    private TroopUpdateMessage troopUpdateMessage;
    private CompressedTroop mockCompressedTroop;

    @BeforeEach
    void setup() {
        troopUpdateMessage = new TroopUpdateMessage();
        mockCompressedTroop = mock(CompressedTroop.class);

        try {
            var field = TroopUpdateMessage.class.getDeclaredField("compressedTroop");
            field.setAccessible(true);
            field.set(troopUpdateMessage, mockCompressedTroop);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetCompressedTroop() {
        assertEquals(mockCompressedTroop, troopUpdateMessage.getCompressedTroop());
    }
}
