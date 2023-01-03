package com.jonas.board.piece;


public abstract class Piece {

    private String value;

    public Piece(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
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

        Piece other = (Piece) obj;
        if (value == null && other.value != null) {
            return false;
        } else if (!value.equals(other.value)) {
            return false;
        }

        return true;
    }

}
