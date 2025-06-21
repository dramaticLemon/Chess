package com.example;

import java.util.HashMap;
import java.util.Map;

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
        figureFactories.put(FigureType.PAWN, (x, y, color) -> new Pawn(x, y, color));
        figureFactories.put(FigureType.ROOK, (x, y, color) -> new Rook(x, y, color));
        figureFactories.put(FigureType.KNIGHT, (x, y, color) -> new Knight(x, y, color));
        figureFactories.put(FigureType.BISHOP, (x, y, color) -> new Bishop(x, y, color));
        figureFactories.put(FigureType.QUEEN, (x, y, color) -> new Queen(x, y, color));
        figureFactories.put(FigureType.KING, (x, y, color) -> new King(x, y, color));
    }

    public static Figure createFigure(FigureType type, int x, int y, Color color) {
        FigureFactory factory = figureFactories.get(type);
        if (factory == null) {
            throw new IllegalArgumentException("Invalid type figure: " + type);
        }
        return factory.create(x, y, color);
    }
}
