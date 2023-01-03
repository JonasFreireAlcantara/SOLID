package com.jonas.tictactoe.player;

import com.jonas.tictactoe.piece.TicTacToePieceType;

public abstract class Player {

    private TicTacToePieceType pieceType;

    public Player(TicTacToePieceType pieceType) {
        this.pieceType = pieceType;
    }

    public TicTacToePieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(TicTacToePieceType pieceType) {
        this.pieceType = pieceType;
    }

}
