package com.jonas.board;

import java.util.Collection;
import java.util.Optional;

import com.jonas.board.exception.HouseNotFoundException;
import com.jonas.board.house.House;
import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;

public abstract class Board {

    protected Collection<House> houses;

    /**
     * Initialize the houses according the implementation.
     */
    public abstract void initialize();

    @Override
    public abstract String toString();

    private House getHouseAtPosition(Position position) throws HouseNotFoundException {
        return houses.stream()
                .filter(house -> house.getPosition().equals(position))
                .findFirst()
                .orElseThrow(() -> new HouseNotFoundException("House not found."));
    }

    public Optional<Piece> getPieceAtPosition(Position position) throws HouseNotFoundException {
        House houseFound = this.getHouseAtPosition(position);

        return Optional.of(houseFound.getPiece());
    }

    public void setPieceAtPosition(Piece piece, Position position) throws HouseNotFoundException {
        House houseFound = this.getHouseAtPosition(position);

        houseFound.setPiece(piece);
    }

    public Collection<House> getHouses() {
        return this.houses;
    }

}
