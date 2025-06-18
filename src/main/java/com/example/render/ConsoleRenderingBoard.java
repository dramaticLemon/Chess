package com.example.render;

import com.example.board.Board;
import com.example.config.Color;
import com.example.figures.Figure;

public class ConsoleRenderingBoard implements Render{
    Board board = Board.getInstance();

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
    char symbol = switch (figure.getType()) {
        case 'K' -> 'K';
        case 'Q' -> 'Q';
        case 'R' -> 'R';
        case 'B' -> 'B';
        case 'N' -> 'N';
        case 'P' -> 'P';
        default -> '?';
    };
    return figure.getColor() == Color.BLACK ? Character.toLowerCase(symbol) : symbol;
}
}

    

