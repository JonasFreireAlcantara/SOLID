package com.jonas.tictactoe.piece;

import com.jonas.board.exception.InvalidPieceTypeException;
import com.jonas.board.piece.Piece;
import com.jonas.board.piece.PieceFactory;
import com.jonas.board.piece.PieceImpl;

public class TicTacToePieceFactoryImpl implements PieceFactory<TicTacToePieceType> {

    @Override
    public Piece create(TicTacToePieceType pieceType) throws InvalidPieceTypeException {
        switch(pieceType) {
            case O:
                return new PieceImpl("O");
            case X:
                return new PieceImpl("X");
            default:
                throw new InvalidPieceTypeException("Invalid piece type.");
        }
    }

}
