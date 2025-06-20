package com.example;

import java.util.Set;

import com.example.board.Board;
import com.example.config.Color;
import com.example.figures.Figure;
import com.example.render.ConsoleRenderingBoard;
import com.example.render.Render;

public class Game {
    Board bord = Board.getInstance();
    Render render = new ConsoleRenderingBoard(bord);
    ConsoleCommandHandler commandHandler = new ConsoleCommandHandler();
    boolean isGameOver = false;

    Color colorToMove = Color.WHITE;
    public void gemeLoop() {
        Figure[][] gameboard = bord.getBoard(); //  TODO не должно быть прямого доступа к массиву

        while(!isGameOver) {
            System.out.println(colorToMove);
            render.render();
            Coordinate coordinate =  commandHandler.getInputCoordinate();
            Figure figure = bord.getFigureAt(coordinate.getColumn(), coordinate.getRow());
               
        
            // if (figure == null || figure.getColor() != this.colorToMove) {
            //     System.out.println("Это не твоя фигура, босс. Ходи нормально.");
            //     continue;
            // }
            
            if (figure == null) {
                continue;
            }

            while (true) {
                System.out.println("Введите координаты для перемещения фигуры");
                Set<Coordinate> possibleMoves = figure.getPossibleMooves(gameboard);
                System.out.println(possibleMoves + " possible moves");
                Coordinate coordinateToMove =  commandHandler.getInputCoordinate();
                if (possibleMoves.contains(coordinateToMove)) {
                    gameboard[coordinate.getRow()][coordinate.getColumn()] = null; 
                    figure.mekeMove(coordinateToMove);
                    gameboard[coordinateToMove.getRow()][coordinateToMove.getColumn()] = figure;
                    break;
                }
              
                }
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
