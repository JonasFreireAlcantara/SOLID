package com.jonas.board.exception;

public class HouseNotFoundException extends RuntimeException {

    public HouseNotFoundException(String message) {
        super(message);
    }
}
