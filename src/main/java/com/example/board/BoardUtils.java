package com.example.board;




import java.util.ArrayList;
import java.util.List;

import com.example.Coordinates;
import com.example.File;

public class BoardUtils {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates sourse, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();

        int fileShift = sourse.file.ordinal() < target.file.ordinal() ? 1 : -1;
        int rankShift = sourse.rank < target.rank ? 1 : -1;

        for (
            int fileIndex = sourse.file.ordinal() + fileShift,
            rank = sourse.rank + rankShift;

            fileIndex != target.file.ordinal() && rank != target.rank;
            fileIndex += fileShift, rank += rankShift
        ) {
            result.add(new Coordinates(File.values()[fileIndex], rank));
        }
        
        return result;
    }
    
    public static List<Coordinates> getVerticalCoordinatesBetween(Coordinates sourse, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();
        int rankShift = sourse.rank < target.rank ? 1:-1;
        for (int rank = sourse.rank + rankShift; rank != target.rank; rank += rankShift) {
            result.add(new Coordinates(sourse.file, rank));
        }

        return result;
    }
    
    public static List<Coordinates> getHorizontalCoordinatesBetween(Coordinates sourse, Coordinates target) {
        List<Coordinates> result = new ArrayList<>();
        int fileShift = sourse.file.ordinal() < target.file.ordinal() ? 1: -1;
        for (
                int fileIndex = sourse.file.ordinal() + fileShift; fileIndex != target.file.ordinal();
                fileIndex += fileShift
        ) {
            result.add(new Coordinates(File.values()[fileIndex], sourse.rank));
        }
        return result;
    }
}
