package com.example;

import java.util.Scanner;
import java.util.Set;

import com.example.board.Board;
import com.example.board.Move;
import com.example.config.Color;
import com.example.figures.Figure;
import com.example.render.BoardConsoleRenderer;

public class ConsoleCommandHandler {
    static Scanner scanner = new Scanner(System.in);

    // координаты для выбора фигуры
    public static Coordinates inputCoordinates() {
        while (true) { 
            System.out.println("Please enter coordinates (ex. a1)");
            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Invalid format");
                continue;
            }
            // d2 file + runk
            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (!Character.isLetter(fileChar)) {
                System.out.println("Invalid format");
                continue;
            }

            if (!Character.isDigit(rankChar)) {
                System.out.println("Invalid format");
            }

            int rank = Character.getNumericValue(rankChar);
            if (rank < 1 || rank > 8) {
                System.out.println("Invalid format");
            }

            File file = File.fromChar(fileChar);
            if (file == null) {
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(file, rank);
         
        }
    }
    
    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) { 

            System.out.println("Enter coordinate for a piece to move");   
            Coordinates coordinates = inputCoordinates();

            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty square");
                continue;
            }

            Figure figure = Board.getFigureAt(coordinates);
            if (figure.getColor() != color) {
                System.out.println("Wron color");
                continue;
            }

            Set<Coordinates> posibleMoveCoordinates = figure.getPossibleMooves(board);
            if (posibleMoveCoordinates.isEmpty()) {
                System.out.println("Blocked figure");
            }

            return coordinates;
        }
    }
    
    /**
     * получить координаты для хода фигуры
     * @param coordinates
     * @return вернуть проверенные координаты для хода
     */
    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("Enter your move for selected piece");
            Coordinates input = inputCoordinates();

            if (!coordinates.contains(input)) {
                System.out.println("Non-available square");
                continue;
            }

            return input;
        }
    }



    public static Move imputMove(Board board, Color color, BoardConsoleRenderer consoleRenderer) {
        while (true) { 

            // получить координаты
            Coordinates sourceCoordinates = ConsoleCommandHandler.inputPieceCoordinatesForColor(color, board);
            Figure figure = Board.getFigureAt(sourceCoordinates); // получить фигуру по этим координатам
            Set<Coordinates> posibleMoves = figure.getPossibleMooves(board);

            consoleRenderer.render(board, figure);
            Coordinates targetCoordinate = ConsoleCommandHandler.inputAvailableSquare(posibleMoves);
            Move move = new Move(sourceCoordinates, targetCoordinate);
            
            // TDOD проверка на шах и мат
            return move;

        }
    }
}


