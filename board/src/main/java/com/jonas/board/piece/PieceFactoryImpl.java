package com.jonas.board.piece;

public class PieceFactoryImpl implements PieceFactory {

    @Override
    public Piece create(PieceType pieceType) {
        return new PieceImpl("");
    }

}
