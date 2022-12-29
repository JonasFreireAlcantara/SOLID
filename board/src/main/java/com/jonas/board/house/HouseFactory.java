package com.jonas.board.house;

import com.jonas.board.position.PositionIdentifier;

public interface HouseFactory {

    public House create(PositionIdentifier positionIdentifier);

}
