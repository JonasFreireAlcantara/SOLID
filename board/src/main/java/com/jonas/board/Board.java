package com.jonas.board;

import java.util.Collection;
import java.util.Optional;

import com.jonas.board.house.House;
import com.jonas.board.position.PositionIdentifier;

public abstract class Board {

    protected Collection<House> houses;

    /**
     * Initialize the houses according the implementation.
     */
    public abstract void initialize();

    public Optional<House> getHouseAtPosition(PositionIdentifier positionIdentifier) {
        return houses.stream()
                .filter(house -> house.getPositionIdentifier().equals(positionIdentifier))
                .findFirst();
    }

}
