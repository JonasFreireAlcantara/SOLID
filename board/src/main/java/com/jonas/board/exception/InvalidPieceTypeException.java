package com.jonas.board.exception;

public class InvalidPieceTypeException extends RuntimeException {

    public InvalidPieceTypeException(String message) {
        super(message);
    }
}
