package com.example.figures;

import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.FigureType;
import com.example.config.Color;

public class Bishop extends LongRangeFigure implements IBishop{

    public Bishop (Coordinates coordinate, Color color) {
        super(coordinate, color);
        this.figureType = FigureType.BISHOP;    
    }
    
   
    @Override 
    public Set<CoordinatesShift> getFigureMoves() {
        return getBishopMoves();
    }
    
}