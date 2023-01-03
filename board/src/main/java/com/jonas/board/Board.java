package com.jonas.board;

import java.util.Collection;
import java.util.Optional;

import com.jonas.board.exception.NotFoundException;
import com.jonas.board.house.House;
import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;

public abstract class Board {

    protected Collection<House> houses;

    /**
     * Initialize the houses according the implementation.
     */
    public abstract void initialize();

    private House getHouseAtPosition(Position position) throws NotFoundException {
        return houses.stream()
                .filter(house -> house.getPosition().equals(position))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("House not found."));
    }

    public Optional<Piece> getPieceAtPosition(Position position) throws NotFoundException {
        House houseFound = this.getHouseAtPosition(position);

        return Optional.of(houseFound.getPiece());
    }

    public void setPieceAtPosition(Piece piece, Position position) throws NotFoundException {
        House houseFound = this.getHouseAtPosition(position);

        houseFound.setPiece(piece);
    }

}
