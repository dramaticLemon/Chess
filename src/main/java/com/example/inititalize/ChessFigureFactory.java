package com.example.inititalize;

import java.util.HashMap;
import java.util.Map;

import com.example.Coordinates;
import com.example.FigureType;
import com.example.config.Color;
import com.example.figures.Bishop;
import com.example.figures.Figure;
import com.example.figures.King;
import com.example.figures.Knight;
import com.example.figures.Pawn;
import com.example.figures.Queen;
import com.example.figures.Rook;

public class ChessFigureFactory {
    private static final Map<FigureType, FigureFactory> figureFactories = new HashMap<>();

    static {
        figureFactories.put(FigureType.PAWN, (coordinate, color) -> new Pawn(coordinate, color));
        figureFactories.put(FigureType.ROOK, (coordinate, color) -> new Rook(coordinate, color));
        figureFactories.put(FigureType.KNIGHT, (coordinate, color) -> new Knight(coordinate, color));
        figureFactories.put(FigureType.BISHOP, (coordinate, color) -> new Bishop(coordinate, color));
        figureFactories.put(FigureType.QUEEN, (coordinate, color) -> new Queen(coordinate, color));
        figureFactories.put(FigureType.KING, (coordinate, color) -> new King(coordinate, color));
    }

    public static Figure createFigure(FigureType type, Coordinates coordinate, Color color) {
        FigureFactory factory = figureFactories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Invalid type figure: " + type);
        }
        return factory.create(coordinate, color); 
    }
}
