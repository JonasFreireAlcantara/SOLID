package com.jonas.example.tictactoe.board;

import java.util.ArrayList;
import java.util.Optional;

import com.jonas.board.Board;
import com.jonas.board.house.House;
import com.jonas.board.house.HouseFactory;
import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;
import com.jonas.example.tictactoe.position.Position2DFactory;

public class TicTacToeBoardImpl extends Board {

    private Position2DFactory position2DFactory;
    private HouseFactory houseFactory;

    protected TicTacToeBoardImpl(Position2DFactory position2DFactory, HouseFactory houseFactory) {
        this.position2DFactory = position2DFactory;
        this.houseFactory = houseFactory;
        this.houses = new ArrayList<>();
    }

    @Override
    public void initialize() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Position position = this.position2DFactory.create(x, y);

                House house = this.houseFactory.create(position);

                this.houses.add(house);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("    0   1   2\n  -------------");

        for (int x = 0; x < 3; x++) {
            sb.append("\n" + x + " | ");

            for (int y = 0; y < 3; y++) {
                Position position = this.position2DFactory.create(x, y);
                Optional<Piece> optionalPiece = this.getPieceAtPosition(position);

                String value = optionalPiece.isPresent() ? optionalPiece.get().getValue() : " ";

                sb.append(value + " | ");
            }
            sb.append("\n  -------------");
        }
        sb.append("\n");

        return sb.toString();
    }

}
