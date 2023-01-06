package com.jonas.board;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return this.houses.stream()
                .filter(house -> house.getPosition().equals(position))
                .findFirst()
                .orElseThrow(() -> new HouseNotFoundException("House not found."));
    }

    public Optional<Piece> getPieceAtPosition(Position position) throws HouseNotFoundException {
        House houseFound = this.getHouseAtPosition(position);

        return houseFound.getPiece();
    }

    public void setPieceAtPosition(Piece piece, Position position) throws HouseNotFoundException {
        House houseFound = this.getHouseAtPosition(position);

        houseFound.setPiece(piece);
    }

    public List<House> getHousesAtPositions(Collection<Position> positions) {
        return this.houses.stream()
                .filter((house) -> positions.contains(house.getPosition()))
                .collect(Collectors.toList());
    }

    public Collection<House> getHouses() {
        return this.houses;
    }

}
