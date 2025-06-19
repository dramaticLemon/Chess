package com.example;

import com.example.board.Board;
import com.example.config.Color;
import com.example.figures.Figure;
import com.example.figures.Pawn;
import com.example.render.ConsoleRenderingBoard;
import com.example.render.Render;

public class Game {
    Board bord = Board.getInstance();
    Render render = new ConsoleRenderingBoard();
    ConsoleCommandHandler commandHandler = new ConsoleCommandHandler();
    boolean isGameOver = false;

    Color colorToMove = Color.WHITE;

    public void gemeLoop() {

        while(!isGameOver) {
            render.render();

            if (colorToMove == Color.WHITE) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }
            Figure[][] gameboard = bord.getBoard(); // не должно быть прямого доступа к массиву

            // получить координаты фигури
            Coordinate coordinate =  commandHandler.getInputCoordinate();
            Figure figure =  (Pawn) bord.getFigureAt(coordinate.getColumn(), coordinate.getRow());
            gameboard[coordinate.getRow()][coordinate.getColumn()] = null;
            // получить коориднаты для хода
            Coordinate coordinateToMove =  commandHandler.getInputCoordinate();
            figure.mekeMove(coordinateToMove);
            gameboard[coordinateToMove.getRow()][coordinateToMove.getColumn()] = figure;
            swapColorToMove();
        }
    }

    private void swapColorToMove() {
        if (this.colorToMove == Color.WHITE) {
            this.colorToMove = Color.BLACK;
        } else {
            this.colorToMove = Color.WHITE;
        }
    }
}
