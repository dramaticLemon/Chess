package com.example.figures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.FigureType;
import com.example.config.Color;

public class Knight extends Figure{

    public Knight (Coordinates coordinate, Color color) {
        super(coordinate, color);
        this.figureType = FigureType.KNIGHT;
    }

    @Override
    public Set<CoordinatesShift> getFigureMoves() {
        return new HashSet<>(Arrays.asList(
            new CoordinatesShift(1, 2),
            new CoordinatesShift(2, 1),

            new CoordinatesShift(2, -1),
            new CoordinatesShift(1, -2),

            new CoordinatesShift(-2, -1),
            new CoordinatesShift(-1, -2),

            new CoordinatesShift(-2, 1),
            new CoordinatesShift(-1, 2)
        ));
    }
    
}
