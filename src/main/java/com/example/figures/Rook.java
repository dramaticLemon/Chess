package com.example.figures;

import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.FigureType;
import com.example.config.Color;


public class Rook extends LongRangeFigure implements IRook{

    public Rook (Coordinates coordinate, Color color) {
        super(coordinate, color);
        this.figureType = FigureType.ROOK;
    }


    @Override
    public Set<CoordinatesShift> getFigureMoves() {
        return getRookMoves();
    }
    
}
