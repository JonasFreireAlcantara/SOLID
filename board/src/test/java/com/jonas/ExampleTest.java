package com.jonas;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("before all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before each");
    }

    @Test
    public void testNumberTwo() {
        System.out.println("test 2");
    }

    @Test
    public void testGetHousesMethod() {
        System.out.println("test 1");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("after each");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all");
    }

}
