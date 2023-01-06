package com.jonas.board.house;

import java.util.Optional;

import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;

public abstract class House {

    protected Piece piece;
    protected Position position;

    public House(Position position) {
        this.position = position;
    }

    public Optional<Piece> getPiece() {
        return Optional.ofNullable(piece);
    }

    public void setPiece(Piece piece) {
        System.out.println("setting piece: " + piece.getValue());
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

}
