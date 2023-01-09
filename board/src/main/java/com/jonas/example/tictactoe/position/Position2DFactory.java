package com.jonas.example.tictactoe.position;

import com.jonas.board.position.Position;

public interface Position2DFactory {

    public final String X = "x";
    public final String Y = "y";

    public Position create(Integer x, Integer y);

}
