package models.message;

import models.game.map.Position;

public class OtherFields {
    private String deckName;
    private String cardName;
    private String myCardId;
    private String opponentCardId;
    private String[] myCardIds;
    private Position position;
    private String sudoCommand;

    // added public by TTamas
    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    // added public by TTamas
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    // added public by TTamas
    public void setMyCardId(String myCardId) {
        this.myCardId = myCardId;
    }

    // added public by TTamas
    public void setOpponentCardId(String opponentCardId) {
        this.opponentCardId = opponentCardId;
    }

    // added public by TTamas
    public void setMyCardIds(String[] myCardIds) {
        this.myCardIds = myCardIds;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    // added public by TTamas
    public void setSudoCommand(String sudoCommand) {
        this.sudoCommand = sudoCommand;
    }
}
