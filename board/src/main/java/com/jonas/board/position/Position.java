package com.jonas.board.position;

import java.util.Map;


public abstract class Position {

    protected Map<String, Integer> values;

    public Position(Map<String, Integer> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Position other = (Position) obj;
        if (values == null && other.values != null) {
            return false;
        } else if (!values.equals(other.values)) {
            return false;
        }

        return true;
    }

    @Override
    public abstract String toString();

}
