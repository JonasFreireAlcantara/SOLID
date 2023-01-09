package com.jonas.example.tictactoe;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import com.jonas.board.Board;
import com.jonas.board.exception.HouseNotFoundException;
import com.jonas.board.house.House;
import com.jonas.board.piece.Piece;
import com.jonas.board.position.Position;
import com.jonas.example.tictactoe.board.TicTacToeBoardFactoryImpl;
import com.jonas.example.tictactoe.exception.InvalidInputException;
import com.jonas.example.tictactoe.piece.TicTacToePieceFactoryImpl;
import com.jonas.example.tictactoe.piece.TicTacToePieceType;
import com.jonas.example.tictactoe.player.Player;
import com.jonas.example.tictactoe.player.PlayerImpl;
import com.jonas.example.tictactoe.position.Position2DFactory;

/**
 * TicTacToe game rules
 */
public class TicTacToeGame {

    private Board board;
    private Player[] players;
    private Player actualPlayer;
    private Scanner scanner;
    private Position2DFactory position2DFactory;
    private TicTacToeHelper helper;

    public TicTacToeGame(Position2DFactory position2DFactory) {
        this.scanner = new Scanner(System.in);
        this.position2DFactory = position2DFactory;
        this.helper = new TicTacToeHelper(scanner, position2DFactory);
    }

    public void initialize() {
        this.board = new TicTacToeBoardFactoryImpl(this.position2DFactory)
                .create();

        this.players = new Player[] {
                new PlayerImpl(TicTacToePieceType.O),
                new PlayerImpl(TicTacToePieceType.X),
        };

        this.actualPlayer = this.players[0];
    }

    public void run() {
        while (!this.isGameOver()) {
            this.showFrame();
            this.round();
        }
        
        this.showFrame();
        this.showFinalResult();
    }
    
    private void round() {
        try {
            this.doRound();
            this.changeActualPlayer();
        } catch (HouseNotFoundException e) {
            System.out.println("A posição não foi encontrada.");
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private void changeActualPlayer() {
        this.actualPlayer = this.getOtherPlayer();
    }

    private Player getOtherPlayer() {
        if (this.actualPlayer.equals(this.players[0])) {
            return this.players[1];
        } else {
            return this.players[0];
        }
    }

    private boolean isGameOver() {
        return this.isWin() || this.isDraw();
    }

    private Player getWinner() {
        List<List<Position>> allPossibleWinPositions = this.helper.getAllPossibleWinPositions();

        for (List<Position> positions : allPossibleWinPositions) {
            Player winner = getWinnerForPositions(positions);
            if (Objects.nonNull(winner)) {
                return winner;
            }
        }

        return null;
    }

    private Player getWinnerForPositions(List<Position> positions) {
        List<House> houses = this.board.getHousesAtPositions(positions);

        if (this.isAllPiecesEquals(houses)) {
            return this.getPlayerRelatedToPiece(houses.get(0).getPiece().get());
        } else {
            return null;
        }
    }

    private Player getPlayerRelatedToPiece(Piece piece) {
        TicTacToePieceType pieceType = TicTacToePieceType.valueOf(piece.getValue());

        if (pieceType.equals(this.actualPlayer.getPieceType())) {
            return this.actualPlayer;
        } else {
            return this.getOtherPlayer();
        }
    }

    private boolean isAllPiecesEquals(List<House> houses) {
        boolean result = false;

        if (isAllPiecesPresent(houses)) {
            Piece pieceOne = houses.get(0).getPiece().get();
            Piece pieceTwo = houses.get(1).getPiece().get();
            Piece pieceThree = houses.get(2).getPiece().get();

            result = pieceOne.equals(pieceTwo) && pieceTwo.equals(pieceThree);
        } else {
            result = false;
        }

        return result;
    }

    public boolean isAllPiecesPresent(List<House> houses) {
        return houses.stream()
                .noneMatch((house) -> house.getPiece().isEmpty());
    }

    private boolean isWin() {
        return Objects.nonNull(this.getWinner());
    }

    private boolean isDraw() {
        return this.board.getHouses()
                .stream()
                .allMatch((house) -> house.getPiece().isPresent());
    }

    private void showFrame() {
        System.out.println(this.board.toString());
        System.out.print("\n\n>>> ");
    }

    private void doRound() throws HouseNotFoundException, InvalidInputException {
        Position chosenPosition = this.helper.getPositionFromUserInput();

        this.checkPositionValidity(chosenPosition);

        this.setPieceOfPlayerAtPosition(this.actualPlayer, chosenPosition);
    }

    private void setPieceOfPlayerAtPosition(Player player, Position position) throws HouseNotFoundException {
        System.out.println("Setting piece of player: " + player + " at position: " + position);

        Piece piece = new TicTacToePieceFactoryImpl()
                .create(player.getPieceType());

        this.board.setPieceAtPosition(piece, position);
    }

    private void checkPositionValidity(Position chosenPosition) throws HouseNotFoundException, InvalidInputException {
        Map<String, Integer> positionValues = chosenPosition.getValues();
        Integer x = positionValues.get(Position2DFactory.X);
        Integer y = positionValues.get(Position2DFactory.Y);

        if ((x > 2 || x < 0) || (y > 2 || y < 0)) {
            throw new InvalidInputException("Entrada fora dos limites permitidos [0-2]");
        }

        Optional<Piece> optionalPiece = this.board.getPieceAtPosition(chosenPosition);
        if (optionalPiece.isPresent()) {
            throw new InvalidInputException("Já existe peça nesta casa.");
        }
    }

    private void showFinalResult() {
        if (this.isDraw()) {
            System.out.println("Deu empate!");
        } else {
            Player winner = this.getWinner();
            System.out.println("O jogador do desenho '" + winner.getPieceType() + "' venceu \\o/");
            System.out.println("Só tenho duas coisas para dizer: PARA BÉNS!");
        }
    }
}
