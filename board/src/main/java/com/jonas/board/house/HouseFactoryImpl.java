package com.jonas.board.house;

import com.jonas.board.position.PositionIdentifier;


public class HouseFactoryImpl implements HouseFactory {

    @Override
    public House create(PositionIdentifier positionIdentifier) {
        return new HouseImpl(positionIdentifier);
    }
    
}
