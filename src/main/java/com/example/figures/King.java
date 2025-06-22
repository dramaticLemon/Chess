package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.FigureType;
import com.example.board.Board;
import com.example.config.Color;

public class King extends Figure{

    public King (Coordinates coordinate, Color color) {
        super(coordinate, color);
        this.figureType = FigureType.KING;
    }
    

    @Override
    public Set<CoordinatesShift> getFigureMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int fileShift = -1; fileShift <= 1; fileShift++) {
            for (int rankShift = -1; rankShift <= 1; rankShift++) {
                if ((fileShift == 0) && (rankShift == 0)) {
                    continue;
                }

                result.add(new CoordinatesShift(fileShift, rankShift));
            }
        }

        return result;
    }


    @Override
    protected boolean isSquareAvialableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvialableForMove(coordinates, board);

        if (result) {
            return !board.isSquareAttakedByCollor(coordinates, color.swap());
        }
        return false;
    }

    
}
