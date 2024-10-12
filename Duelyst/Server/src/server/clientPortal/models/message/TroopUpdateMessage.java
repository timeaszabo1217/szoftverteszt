package server.clientPortal.models.message;

import server.clientPortal.models.comperessedData.CompressedTroop;
import server.gameCenter.models.game.Troop;

class TroopUpdateMessage {
    private CompressedTroop compressedTroop;

    TroopUpdateMessage(Troop troop) {
        this.compressedTroop = troop.toCompressedTroop();
    }
}
