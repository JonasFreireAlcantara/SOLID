package com.jonas.example.tictactoe;

import com.jonas.board.house.HouseFactory;
import com.jonas.board.house.HouseFactoryImpl;
import com.jonas.board.position.PositionBuilderImpl;
import com.jonas.example.tictactoe.position.Position2DFactory;
import com.jonas.example.tictactoe.position.Position2DFactoryImpl;

public class Run {

    public static void main(String[] args) {
        Position2DFactory position2DFactory = new Position2DFactoryImpl(new PositionBuilderImpl());
        HouseFactory houseFactory = new HouseFactoryImpl();

        TicTacToeGame game = new TicTacToeGame(position2DFactory, houseFactory);

        game.initialize();
        game.run();
    }

}
