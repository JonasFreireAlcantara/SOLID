package com.jonas.example.tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.jonas.board.position.Position;
import com.jonas.example.tictactoe.exception.InvalidInputException;
import com.jonas.example.tictactoe.position.Position2DFactory;

public class TicTacToeHelper {

    private Scanner scanner;
    private Position2DFactory position2DFactory;

    public TicTacToeHelper(Scanner scanner, Position2DFactory position2DFactory) {
        this.scanner = scanner;
        this.position2DFactory = position2DFactory;
    }

    public Position getPositionFromUserInput()
            throws InvalidInputException {
        String input = scanner.nextLine();
        if (input.length() != 3) {
            throw new InvalidInputException("Entrada inválida.");
        }

        String[] entries = input.split("-");

        Integer x = Integer.parseInt(entries[0]);
        Integer y = Integer.parseInt(entries[1]);
        return this.position2DFactory.create(x, y);
    }

    public List<List<Position>> getAllPossibleWinPositions() {
        return Arrays.asList(
            Arrays.asList(
                    this.position2DFactory.create(0, 0),
                    this.position2DFactory.create(0, 1),
                    this.position2DFactory.create(0, 2))
            ,
            Arrays.asList(
                    this.position2DFactory.create(1, 0),
                    this.position2DFactory.create(1, 1),
                    this.position2DFactory.create(1, 2))
            ,
            Arrays.asList(
                    this.position2DFactory.create(2, 0),
                    this.position2DFactory.create(2, 1),
                    this.position2DFactory.create(2, 2))
            ,
            Arrays.asList(
                    this.position2DFactory.create(0, 0),
                    this.position2DFactory.create(1, 0),
                    this.position2DFactory.create(2, 0))
            ,
            Arrays.asList(
                    this.position2DFactory.create(0, 1),
                    this.position2DFactory.create(1, 1),
                    this.position2DFactory.create(2, 1))
            ,
            Arrays.asList(
                    this.position2DFactory.create(0, 2),
                    this.position2DFactory.create(1, 2),
                    this.position2DFactory.create(2, 2))
            ,
            Arrays.asList(
                    this.position2DFactory.create(0, 0),
                    this.position2DFactory.create(1, 1),
                    this.position2DFactory.create(2, 2))
            ,
            Arrays.asList(
                    this.position2DFactory.create(2, 0),
                    this.position2DFactory.create(1, 1),
                    this.position2DFactory.create(0, 2))
        );
    }
    
}
