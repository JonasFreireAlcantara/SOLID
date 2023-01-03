package com.jonas.board.position;

import java.util.Map;

public class PositionImpl extends Position {

    protected PositionImpl(Map<String, Integer> values) {
        super(values);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        values.forEach(
                (key, value) -> stringBuilder.append(key + ": " + value + " "));

        return stringBuilder.toString();
    }

}
