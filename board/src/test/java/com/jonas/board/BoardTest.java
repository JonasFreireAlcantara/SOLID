package com.jonas.board;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jonas.board.house.House;
import com.jonas.board.house.HouseImpl;
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

}
