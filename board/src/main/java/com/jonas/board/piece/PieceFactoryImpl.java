package com.jonas.board.piece;

import com.jonas.board.exception.InvalidPieceTypeException;
import com.jonas.tictactoe.piece.TicTacToePieceType;

public class PieceFactoryImpl implements PieceFactory<TicTacToePieceType> {

    @Override
    public Piece create(TicTacToePieceType pieceType) throws InvalidPieceTypeException {
        return new PieceImpl(pieceType.toString());
    }

}
