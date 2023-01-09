package com.jonas.board.position;

import java.util.HashMap;
import java.util.Map;

public abstract class PositionBuilder {

    protected Map<String, Integer> values;

    public PositionBuilder() {
        this.values = new HashMap<>();
    }

    public PositionBuilder put(String key, Integer value) {
        this.values.put(key, value);

        return this;
    }

    public Position build() {
        Position newPosition = new PositionImpl(this.values);

        this.values = new HashMap<>();
        return newPosition;
    }

}
