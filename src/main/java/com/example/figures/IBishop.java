package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import com.example.CoordinatesShift;

public interface  IBishop {
    
    default Set<CoordinatesShift> getBishopMoves() {
            Set<CoordinatesShift> result = new HashSet<>();

            // bottom-left to top-right
            for (int i = -7; i <= 7; i++) {
                if (i == 0) continue;

                result.add(new CoordinatesShift(i, i));
            }

            // top-left to bottom-right
            for (int i = -7; i <= 7; i++) {
                if (i == 0) continue;

                result.add(new CoordinatesShift(i, -i));
            }

            return result;
        }
}
