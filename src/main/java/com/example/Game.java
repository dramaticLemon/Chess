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
        
        while(!isGameOver) {

            if (colorToMove.equals(Color.WHITE)) {
                System.out.println("======WHITE MOVE======");
            } else {
                System.out.println("======BLACK MOVE======");
            }

            render.render();

            Coordinate coordinate;
            Figure figure;

            while (!isGameOver) {
                coordinate =  commandHandler.getInputCoordinate();
                figure = bord.getFigureAt(coordinate.getColumn(), coordinate.getRow());
                
                if (figure == null || figure.getColor() != this.colorToMove) {
                    System.out.println("Wrong colr figure, select again");
                    continue;
                }

              

                Set<Coordinate> possibleMoves = figure.getPossibleMooves(bord.getView());
                if (possibleMoves.isEmpty()) {
                    continue;
                }
                render.renderCoordinate(possibleMoves);

                while (!isGameOver) {
                    System.out.println("Enter Coordinte to move: ");
                    Coordinate coordinateToMove = commandHandler.getInputCoordinate();

                    if (possibleMoves.contains(coordinateToMove)) {
                        Figure target = bord.getFigureAt( coordinateToMove.getColumn(), coordinateToMove.getRow());
                        if (target != null && target.getType() == 'K') {
                            this.isGameOver = true;
                            System.out.println("WINED: " + this.colorToMove);
                        }
                        bord.setFigure(null, coordinate.getRow(), coordinate.getColumn()); 
                        figure.mekeMove(coordinateToMove);
                        bord.setFigure(figure, coordinateToMove.getRow(), coordinateToMove.getColumn());
                        break;
                    } else {
                        System.out.println("You can't go there. Try again.");
                    }
                    
                }

                break;
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
