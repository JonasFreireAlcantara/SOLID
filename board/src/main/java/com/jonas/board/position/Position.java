package com.jonas.board.position;

import java.util.Map;


public abstract class Position {

    protected Map<String, Integer> values;

    public Position(Map<String, Integer> values) {
        this.values = values;
    }

    public Map<String, Integer> getValues() {
        return this.values;
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
        } else if (!isMapsEquals(this.values, other.values))
            return false;

        return true;
    }

    private boolean isMapsEquals(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        } else {
            return map1.keySet()
                    .stream()
                    .allMatch(key -> map1.get(key).equals(map2.get(key)));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        values.forEach(
                (key, value) -> stringBuilder.append(key + ": " + value + " "));

        return stringBuilder.toString();
    }

}
