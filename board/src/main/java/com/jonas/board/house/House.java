package com.jonas.board.house;

import com.jonas.board.piece.Piece;
import com.jonas.board.position.PositionIdentifier;

public abstract class House {

    protected Piece piece;
    protected PositionIdentifier positionIdentifier;

    public House(PositionIdentifier positionIdentifier) {
        this.positionIdentifier = positionIdentifier;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public PositionIdentifier getPositionIdentifier() {
        return positionIdentifier;
    }

}
