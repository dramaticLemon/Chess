package com.example.render;

import java.util.Set;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.board.Board;
import com.example.config.Color;
import com.example.figures.Figure;

public class ConsoleRenderingBoard implements Render{    
    Board board;

    public ConsoleRenderingBoard(Board board) {
        this.board = board;
    }

    @Override
    public void render() {
        String[] color = {"\033[47m", "\033[40m"};
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int i = 8; i > 0; i--) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                Figure fig = board.getFigureAt(j, 8 - i);
                char symbol = fig != null ? getSymbol(fig) : ' ';
                System.out.print(color[(i + j) % 2] + " " + symbol + " ");
            }
            System.out.println("\033[0m");
        }
    }

    @Override
    public void renderCoordinate(Set<Coordinate> possibleMoves) {
        String[] bgColors = {"\033[47m", "\033[40m"};
        String greenText = "\033[32m";
        String magentaText = "\033[35m";
        String reset = "\033[0m";

        System.out.println("   A  B  C  D  E  F  G  H");

        for (int i = 8; i > 0; i--) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                Coordinate coord = new ValidateCoordinate(8 - i, j);
                Figure fig = board.getFigureAt(j, 8 - i);
                char symbol = fig != null ? getSymbol(fig) : ' ';

                String bg = bgColors[(i + j) % 2];
                String color = "";

                if (possibleMoves.contains(coord)) {
                    if (fig == null) {
                        color = greenText;
                        symbol = '●';
                    } else {
                        color = magentaText;
                    }
                }

                System.out.print(bg + color + " " + symbol + " " + reset);
            }
        System.out.println();
        }
    }

    private char getSymbol(Figure figure) {
        char type = figure.getType();
        boolean isWhite = figure.getColor() == Color.WHITE;

        return switch (type) {
            case 'K' -> isWhite ? '♔' : '♚';
            case 'Q' -> isWhite ? '♕' : '♛';
            case 'R' -> isWhite ? '♖' : '♜';
            case 'B' -> isWhite ? '♗' : '♝';
            case 'N' -> isWhite ? '♘' : '♞';
            case 'P' -> isWhite ? '♙' : '♟';
            default -> '?';
        };

    }
}

    

