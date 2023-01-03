package com.jonas.board.house;

import com.jonas.board.position.Position;


public class HouseFactoryImpl implements HouseFactory {

    @Override
    public House create(Position position) {
        return new HouseImpl(position);
    }
    
}
