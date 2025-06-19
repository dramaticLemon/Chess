package com.example.render;

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

    

