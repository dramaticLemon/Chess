package com.example;

import java.util.LinkedHashMap;
import java.util.Map;
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

    public static final Map<FigureType, Integer> blackLostFigures = new LinkedHashMap<>();
    public static final Map<FigureType, Integer> whiteLostFigures = new LinkedHashMap<>();
    
    Color colorToMove = Color.WHITE;

    static {
        for (FigureType type : FigureType.values()) {
            blackLostFigures.put(type, 0);
            whiteLostFigures.put(type, 0);
        }
    }

    public void gemeLoop() {
        
        while(!isGameOver) {

            if (colorToMove.equals(Color.WHITE)) {
                System.out.println("======WHITE MOVE======");
            } else {
                System.out.println("======BLACK MOVE======");
            }

            render.renderLoseFigure(whiteLostFigures, Color.WHITE);
            render.render();
            render.renderLoseFigure(blackLostFigures, Color.BLACK);


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

                       
                        if (target != null) {
                            FigureType type = target.getType();
                            Color capturedColor = target.getColor();

                            if (capturedColor == Color.WHITE) {
                                whiteLostFigures.put(type, whiteLostFigures.get(type) + 1);
                            } else {
                                blackLostFigures.put(type, blackLostFigures.get(type) + 1);
                            }
                        }

                        if (target != null && target.getType() == FigureType.KING) {
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
