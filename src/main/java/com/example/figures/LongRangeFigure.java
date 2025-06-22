package com.example.figures;

import java.util.List;

import com.example.Coordinates;
import com.example.board.Board;
import com.example.board.BoardUtils;
import com.example.config.Color;

public abstract class LongRangeFigure extends Figure{

    public LongRangeFigure(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }

    @Override
    protected boolean isSquareAvialableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForAttack(coordinates, board);

        if (result) {
            return isSquareAvailableForAttack(coordinates, board);
        } else {
            return false;
        }

    }

    @Override
    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        List<Coordinates> coordinatesBeteween;
        if(this.coordinate.file == coordinates.file) {
            coordinatesBeteween = BoardUtils.getVerticalCoordinatesBetween(this.coordinate, coordinates);
        } else if (this.coordinate.rank.equals(coordinates.rank)) {
            coordinatesBeteween = BoardUtils.getHorizontalCoordinatesBetween(this.coordinate, coordinates);
        } else {
            coordinatesBeteween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinate, coordinates);
        }

        for (Coordinates coord: coordinatesBeteween) {
            if (!board.isSquareEmpty(coord)) {
                return false;
            }
        }
        
        return true;
    }
}
