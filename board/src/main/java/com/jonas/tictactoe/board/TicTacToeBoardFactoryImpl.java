package com.jonas.tictactoe.board;

import com.jonas.board.Board;
import com.jonas.board.BoardFactory;
import com.jonas.tictactoe.position.Position2DFactory;


public class TicTacToeBoardFactoryImpl implements BoardFactory {

    private Position2DFactory position2DFactory;

    public TicTacToeBoardFactoryImpl(Position2DFactory position2DFactory) {
        this.position2DFactory = position2DFactory;
    }

    @Override
    public Board create() {
        Board board = new TicTacToeBoardImpl(this.position2DFactory);
        board.initialize();

        return board;
    }

}
