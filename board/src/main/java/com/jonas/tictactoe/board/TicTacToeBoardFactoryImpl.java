package com.jonas.tictactoe.board;

import com.jonas.board.Board;
import com.jonas.board.BoardFactory;


public class TicTacToeBoardFactoryImpl implements BoardFactory {

    @Override
    public Board create() {
        Board board = new TicTacToeBoardImpl();
        board.initialize();

        return board;
    }

}
