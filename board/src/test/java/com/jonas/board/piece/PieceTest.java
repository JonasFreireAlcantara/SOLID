package com.jonas.board.piece;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PieceTest {

    private Piece basePiece;

    @BeforeEach
    public void initialize() {
        this.basePiece = new PieceImpl("hello");
    }

    @Test
    public void testEquals_whenValueIsEquals() {
        Piece otherPiece = new PieceImpl("hello");

        boolean isEquals = this.basePiece.equals(otherPiece);

        Assertions.assertTrue(isEquals);
    }

    @Test
    public void testEquals_whenValueIsDifferent() {
        Piece otherPiece = new PieceImpl("world");

        boolean isEquals = this.basePiece.equals(otherPiece);

        Assertions.assertFalse(isEquals);
    }

    @Test
    public void testGetValue_shouldReturnCorrectValue() {
        String value = this.basePiece.getValue();

        Assertions.assertEquals("hello", value);
    }

}
