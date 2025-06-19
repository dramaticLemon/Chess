package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.CoordinateShif;
import com.example.config.Color;

public class Pawn extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Pawn.class);
    private boolean isMoved;

    public Pawn(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk; 
        this.color = color;
        this.type = 'P';
        this.isMoved = false; // по умолчанию пешка еще не двигалась
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.debug("Pawn is move");
        setCoordinate(coordinate);


    }

    private void setCoordinate(Coordinate coordinate) {
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }

    public void setMoved(boolean isMoved) {
        this.isMoved = false;
    }

    public boolean isMoved() {
        return this.isMoved;
    }

    @Override
    public Set<CoordinateShif> getPossibleMooves(Figure[][] board) {
        Set<CoordinateShif> possibleMovCoordinateShifs = new HashSet<>();
    
        int direction = (this.color == Color.WHITE) ? 1 : -1;
        int nextRowOneStep = this.runk - direction;

        if (nextRowOneStep >= 0 && nextRowOneStep < board.length) {
            
            // один ход вперед
            if (board[nextRowOneStep][this.file] == null) {
                possibleMovCoordinateShifs.add(new CoordinateShif(this.file, nextRowOneStep));
            }
            // два хода вперед
            int nextRowTwoSteps = this.runk - 2 * direction;
            if (!isMoved() && nextRowTwoSteps >= 0 && nextRowTwoSteps < board.length) {
                if ( board[nextRowTwoSteps][this.file] == null ) {
                    possibleMovCoordinateShifs.add(new CoordinateShif(this.file, nextRowTwoSteps));
                    }
                }
            }
        
        int diagLeftRow = this.runk - direction;
        int diagLeftCol = this.file - 1;
        diagonalMove(diagLeftRow, diagLeftCol, board, possibleMovCoordinateShifs);
        int diagRightRow = this.runk - direction;
        int diagRightCol = this.file + 1;
        diagonalMove(diagRightRow, diagRightCol, board, possibleMovCoordinateShifs);
    
        // TODO сделать проверку взятия на проходе
        return possibleMovCoordinateShifs;
    }

    private void diagonalMove(int row, int col, Figure[][] board, Set<CoordinateShif> possibleMovCoordinateShifs) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            Figure targetPiece = board[row][col];
            if (targetPiece != null && targetPiece.getColor() != this.color) {
                possibleMovCoordinateShifs.add(new CoordinateShif(row, col));
            }
        }
    }
}
