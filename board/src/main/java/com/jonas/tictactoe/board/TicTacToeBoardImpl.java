package com.jonas.tictactoe.board;

import java.util.ArrayList;

import com.jonas.board.Board;
import com.jonas.board.house.House;
import com.jonas.board.house.HouseFactoryImpl;
import com.jonas.board.position.Position;
import com.jonas.board.position.PositionBuilderImpl;

public class TicTacToeBoardImpl extends Board {

    protected TicTacToeBoardImpl() {
        this.houses = new ArrayList<>();
    }

    @Override
    public void initialize() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                Position position = new PositionBuilderImpl()
                        .put("x", x)
                        .put("y", y)
                        .build();

                House house = new HouseFactoryImpl().create(position);

                this.houses.add(house);

            }
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
