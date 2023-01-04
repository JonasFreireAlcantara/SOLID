package com.jonas.tictactoe.position;

import com.jonas.board.position.Position;
import com.jonas.board.position.PositionBuilder;

public class Position2DFactoryImpl implements Position2DFactory {

    private PositionBuilder positionBuilder;

    public Position2DFactoryImpl(PositionBuilder positionBuilder) {
        this.positionBuilder = positionBuilder;
    }

    @Override
    public Position create(Integer x, Integer y) {
        return this.positionBuilder
                .put(X, x)
                .put(Y, y)
                .build();
    }
    
}
