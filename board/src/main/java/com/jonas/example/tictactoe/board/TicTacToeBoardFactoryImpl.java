package com.jonas.example.tictactoe.board;

import com.jonas.board.Board;
import com.jonas.board.BoardFactory;
import com.jonas.board.house.HouseFactory;
import com.jonas.example.tictactoe.position.Position2DFactory;


public class TicTacToeBoardFactoryImpl implements BoardFactory {

    private Position2DFactory position2DFactory;
    private HouseFactory houseFactory;

    public TicTacToeBoardFactoryImpl(Position2DFactory position2DFactory, HouseFactory houseFactory) {
        this.position2DFactory = position2DFactory;
        this.houseFactory = houseFactory;
    }

    @Override
    public Board create() {
        Board board = new TicTacToeBoardImpl(this.position2DFactory, this.houseFactory);
        board.initialize();

        return board;
    }

}
