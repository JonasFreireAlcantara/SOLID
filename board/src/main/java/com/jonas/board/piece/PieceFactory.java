package com.jonas.board.piece;

import com.jonas.board.exception.InvalidPieceTypeException;

public interface PieceFactory <T extends PieceType> {

    public Piece create(T pieceType) throws InvalidPieceTypeException;

}
