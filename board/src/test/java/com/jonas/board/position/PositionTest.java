package com.jonas.board.position;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {

    private PositionBuilder positionBuilder;
    private Position basePosition;

    @BeforeEach
    public void initialize() {
        this.positionBuilder = new PositionBuilderImpl();
        this.basePosition = this.positionBuilder
                .put("key1", 1234)
                .put("key2", 4321)
                .build();
    }

    @Test
    public void testEquals_whenMapsAreEquals() {
        Position otherPosition = this.positionBuilder
                .put("key1", 1234)
                .put("key2", 4321)
                .build();

        boolean result = this.basePosition.equals(otherPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testEquals_whenMapsKeySetAreDifferent() {
        Position position2 = this.positionBuilder
                .put("key different 1", 1234)
                .put("key2", 4321)
                .build();

        boolean result = this.basePosition.equals(position2);

        Assertions.assertFalse(result);
    }

    @Test
    public void testEquals_whenMapsValueSetAreDifferent() {
        Position position2 = this.positionBuilder
                .put("key1", 1000)
                .put("key2", 2000)
                .build();

        boolean result = this.basePosition.equals(position2);

        Assertions.assertFalse(result);
    }

    @Test
    public void testEquals_whenSecondMapMissOneKeyValuePair() {
        Position position2 = this.positionBuilder
                .put("key1", 1234)
                .build();

        boolean result = this.basePosition.equals(position2);

        Assertions.assertFalse(result);
    }

    @Test
    public void testToString() {
        String expectedString = "key1: 1234 key2: 4321 ";

        String result = this.basePosition.toString();

        Assertions.assertEquals(expectedString, result);
    }

    @Test
    public void testGetValues_shouldReturnCorrectMap() {
        Map<String, Integer> expectedMap = Map.of("key", 11111);
        Position position = new PositionImpl(expectedMap);

        Map<String, Integer> resultMap = position.getValues();

        Assertions.assertTrue(expectedMap == resultMap);
    }

}
