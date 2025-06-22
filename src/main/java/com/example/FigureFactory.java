package com.example;

import com.example.config.Color;
import com.example.figures.Bishop;
import com.example.figures.Figure;
import com.example.figures.King;
import com.example.figures.Knight;
import com.example.figures.Pawn;
import com.example.figures.Queen;
import com.example.figures.Rook;

public class FigureFactory {
     public Figure fromFenChar(char fenChar, Coordinates coordinates) {
        switch (fenChar) {
            case 'p':
                return new Pawn(coordinates, Color.BLACK);
            case 'P':
                return new Pawn(coordinates, Color.WHITE);

            case 'r':
                return new Rook(coordinates, Color.BLACK);
            case 'R':
                return new Rook(coordinates, Color.WHITE);

            case 'n':
                return new Knight(coordinates, Color.BLACK);
            case 'N':
                return new Knight(coordinates, Color.WHITE);

            case 'b':
                return new Bishop(coordinates, Color.BLACK);
            case 'B':
                return new Bishop(coordinates, Color.WHITE);

            case 'q':
                return new Queen(coordinates, Color.BLACK);
            case 'Q':
                return new Queen(coordinates, Color.WHITE);

            case 'k':
                return new King(coordinates, Color.BLACK);
            case 'K':
                return new King(coordinates, Color.WHITE);

            default:
                throw new RuntimeException("Unknown FEN char!");
        }
    }
}
