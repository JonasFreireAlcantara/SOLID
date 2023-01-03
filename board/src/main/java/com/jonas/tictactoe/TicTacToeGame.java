package com.jonas.tictactoe;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import com.jonas.board.Board;
import com.jonas.board.exception.HouseNotFoundException;
import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;
import com.jonas.board.position.PositionBuilderImpl;
import com.jonas.tictactoe.board.TicTacToeBoardFactoryImpl;
import com.jonas.tictactoe.exception.InvalidInputException;
import com.jonas.tictactoe.piece.TicTacToePieceFactoryImpl;
import com.jonas.tictactoe.piece.TicTacToePieceType;
import com.jonas.tictactoe.player.Player;
import com.jonas.tictactoe.player.PlayerImpl;

/**
 * TicTacToe game rules
 */
public class TicTacToeGame {

    private Board board;
    private Player[] players;
    private Player actualPlayer;
    private Scanner scanner = new Scanner(System.in);

    public void initialize() {
        this.board = new TicTacToeBoardFactoryImpl().create();

        this.players = new Player[] {
            new PlayerImpl(TicTacToePieceType.O),
            new PlayerImpl(TicTacToePieceType.X),
        };

        this.actualPlayer = this.players[0];
    }

    public void run() {
        while (!this.isGameOver()) {
            this.changeActualPlayer();
            this.showFrame();
            this.round();
        }

        this.showFrame();
        this.showFinalResult();
    }

    private void round() {
        try {
            this.doRound();
        } catch (HouseNotFoundException e) {
            System.out.println("A posição não foi encontrada.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private void changeActualPlayer() {
        if (this.actualPlayer.equals(this.players[0])) {
            this.actualPlayer = this.players[1];
        } else {
            this.actualPlayer = this.players[0];
        }
    }

    private boolean isGameOver() {
        return this.isDraw() || this.isWin();
    }

    private Player getWinner() {
        return null;
    }

    private boolean isWin() {
        return Objects.nonNull(this.getWinner());
    }

    private boolean isDraw() {
        return this.board.getHouses()
                .stream()
                .allMatch((house) -> Objects.nonNull(house.getPiece()));
    }

    private void showFrame() {
        System.out.println(this.board.toString());
        System.out.print("\n\n>>> ");
    }

    private void doRound() throws HouseNotFoundException, InvalidInputException {
        Position chosenPosition = this.getPositionFromUserInput();

        this.checkPositionValidity(chosenPosition);

        this.setPieceOfPlayerAtPosition(this.actualPlayer, chosenPosition);
    }

    private void setPieceOfPlayerAtPosition(Player player, Position position) throws HouseNotFoundException {
        Piece piece = new TicTacToePieceFactoryImpl()
                    .create(player.getPieceType());

        this.board.setPieceAtPosition(piece, position);
    }

    private void checkPositionValidity(Position chosenPosition) throws HouseNotFoundException, InvalidInputException {
        Map<String, Integer> positionValues = chosenPosition.getValues();
        Integer x = positionValues.get("x");
        Integer y = positionValues.get("y");

        if ((x > 2 || x < 0) || (y > 2 || y < 0)) {
            throw new InvalidInputException("");
        }

        Optional<Piece> optionalPiece = this.board.getPieceAtPosition(chosenPosition);
        if (optionalPiece.isPresent()) {
            throw new InvalidInputException("Já existe peça nesta casa.");
        }
    }

    private Position getPositionFromUserInput() throws InvalidInputException {
        String input = this.scanner.nextLine();
        if (input.length() != 3) {
            throw new InvalidInputException("Entrada inválida.");
        }

        String [] entries = input.split("-");

        return new PositionBuilderImpl()
                .put("x", Integer.parseInt(entries[0]))
                .put("y", Integer.parseInt(entries[1]))
                .build();
    }

    private void showFinalResult() {
        if (this.isDraw()) {
            System.out.println("Deu empate!");
        } else {
            Player winner = this.getWinner();
            System.out.println(winner.getPieceType() + " venceu \\o/");
            System.out.println("Só tenho duas coisas para dizer: PARA BÉNS!");
        }
    }
}
