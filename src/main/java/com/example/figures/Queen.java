package com.example.figures;

import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.config.Color;

public class Queen extends LongRangeFigure implements IBishop, IRook{

    public Queen (Coordinates coordinate, Color color) {
        super(coordinate, color);
        this.figureType = figureType.QUEEN;
    }

   
    
    @Override
    public Set<CoordinatesShift> getFigureMoves() {
        Set<CoordinatesShift> moves = getBishopMoves();
        moves.addAll(getRookMoves());
        
        return moves;
    }
}
