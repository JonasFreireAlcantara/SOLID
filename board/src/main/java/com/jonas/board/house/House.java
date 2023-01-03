package com.jonas.board.house;

import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;

public abstract class House {

    protected Piece piece;
    protected Position position;

    public House(Position position) {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

}
