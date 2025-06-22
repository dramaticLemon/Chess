package com.example.figures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.FigureType;
import com.example.board.Board;
import com.example.board.BoardUtils;
import com.example.config.Color;


public class Pawn extends Figure{

     public Pawn (Coordinates coordinate, Color color) {
        super(coordinate, color);
        this.figureType = FigureType.PAWN;
    }
    

    @Override
    public Set<CoordinatesShift> getFigureMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        if (color == Color.WHITE) {
            result.add(new CoordinatesShift(0, 1));

            if (coordinate.rank == 2) {
                result.add(new CoordinatesShift(0, 2));
            }

            result.add(new CoordinatesShift(-1, 1));
            result.add(new CoordinatesShift(1, 1));
        } else {
            result.add(new CoordinatesShift(0, -1));

            if (coordinate.rank == 7) {
                result.add(new CoordinatesShift(0, -2));

            }

            result.add(new CoordinatesShift(-1, -1));
            result.add(new CoordinatesShift(1, -1));
        }

        return result;
    }


    @Override
    protected boolean isSquareAvialableForMove(Coordinates coordinates, Board board) {
        if (this.coordinate.file == coordinates.file) {
            int rankShift = Math.abs(this.coordinate.rank - coordinates.rank);

            if (rankShift == 2) {
                List<Coordinates> between = BoardUtils.getVerticalCoordinatesBetween(this.coordinate, coordinates);

                return (board.isSquareEmpty(between.get(0))) && board.isSquareEmpty(coordinates);
            } else {
                return board.isSquareEmpty(coordinates);
            }

        } else {
            if (board.isSquareEmpty(coordinates)) {
                return false;

            } else {
                return Board.getFigureAt(coordinates).color != color;
            }
        }
        
    }

}
