package com.jonas.board;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jonas.board.exception.HouseNotFoundException;
import com.jonas.board.exception.InvalidPieceTypeException;
import com.jonas.board.house.House;
import com.jonas.board.house.HouseImpl;
import com.jonas.board.piece.Piece;
import com.jonas.board.piece.PieceImpl;
import com.jonas.board.position.Position;
import com.jonas.board.position.PositionBuilder;
import com.jonas.board.position.PositionBuilderImpl;

public class BoardTest {

    private class BoardMock extends Board {

        public BoardMock(Collection<House> houses) {
            this.houses = houses;
        }

        @Override
        public void initialize() { }

        @Override
        public String toString() {
            return null;
        }
    }

    private Board boardMock;
    private PositionBuilder positionBuilder;
    private List<House> houses;

    @BeforeEach
    public void initializeVariables() {
        this.positionBuilder = new PositionBuilderImpl();
        Position position1 = positionBuilder.put("key", 1).build();
        Position position2 = positionBuilder.put("key", 2).build();
        Position position3 = positionBuilder.put("key", 3).build();

        this.houses= List.of(
            new HouseImpl(position1),
            new HouseImpl(position2),
            new HouseImpl(position3)
        );

        this.houses.get(0).setPiece(new PieceImpl("piece"));

        this.boardMock = new BoardMock(houses);
    }

    @Test
    public void testGetHousesAtPositionsMethod_shouldReturnCorrectHouse() {
        List<House> expectedHouses = this.houses.subList(0, 2);
        List<Position> positionsToSearch = List.of(
            this.positionBuilder.put("key", 1).build(),
            this.positionBuilder.put("key", 2).build()
        );

        List<House> housesFound = this.boardMock.getHousesAtPositions(positionsToSearch);

        Assertions.assertEquals(expectedHouses, housesFound);
    }

    @Test
    public void testGetHousesAtPositionsMethod_shouldReturnEmptyList() {
        List<House> expectedHouses = List.of();
        List<Position> positionsToSearchThatDoesNotExist = List.of(
            this.positionBuilder.put("key", 100).build(),
            this.positionBuilder.put("key", 200).build()
        );

        List<House> housesFound = this.boardMock.getHousesAtPositions(positionsToSearchThatDoesNotExist);

        Assertions.assertEquals(expectedHouses, housesFound);
    }

    @Test
    public void testGetHouses_shouldReturnCorrectListOfHouses() {
        Collection<House> housesReturned = this.boardMock.getHouses();

        Assertions.assertEquals(this.houses, housesReturned);
    }

    @Test
    public void testGetPieceAtPosition_shouldRaiseHouseNotFoundException() {
        Position positionThatDoesNotExist = this.positionBuilder.put("key", 10000).build();

        Assertions.assertThrows(
                HouseNotFoundException.class,
                () -> this.boardMock.getPieceAtPosition(positionThatDoesNotExist));
    }

    @Test
    public void testGetPieceAtPosition_returnPieceCorrespondingTheFirstHouse() {
        House firstHouse = this.houses.get(0);
        Piece expectedPiece = firstHouse.getPiece().get();
        Position positionOfExpectedPiece = firstHouse.getPosition();

        Piece pieceReturned = this.boardMock.getPieceAtPosition(positionOfExpectedPiece).get();

        Assertions.assertEquals(expectedPiece, pieceReturned);
    }

    @Test
    public void testSetPieceAtPosition_shouldRaiseHouseNotFoundException() {
        Position positionThatDoesNotExist = this.positionBuilder.put("key", 10000).build();
        Piece newPiece = new PieceImpl("asdf");

        Assertions.assertThrows(
                HouseNotFoundException.class,
                () -> this.boardMock.setPieceAtPosition(newPiece, positionThatDoesNotExist));
    }

    @Test
    public void testSetPieceAtPosition_updateIsDoneCorrectly() {
        House firstHouse = this.houses.get(0);
        Position position = firstHouse.getPosition();
        Piece newPiece = new PieceImpl("my new piece element asgasgasg");

        this.boardMock.setPieceAtPosition(newPiece, position);

        Assertions.assertEquals(newPiece, firstHouse.getPiece().get());
    }

}
