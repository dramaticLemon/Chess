package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.config.Color;


/**
 * пешка доходит до края поля и больше ничего не происходит
 */
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
        logger.info("Pawn is move");
        if (!this.isMoved) {
            this.isMoved = true;
            logger.info(this.isMoved ? "Pawn has moved" : "Pawn has not moved yet");
        }
        setCoordinate(coordinate);
    }

    private void setCoordinate(Coordinate coordinate) {
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }

 
    @Override
    public Set<Coordinate> getPossibleMooves(Figure[][] board) {
        Set<Coordinate> possibleMovCoordinateShifs = new HashSet<>();
    
        int direction = (this.color == Color.WHITE) ? 1 : -1;
        int nextRowOneStep = this.runk - direction;

        if (nextRowOneStep >= 0 && nextRowOneStep < board.length) {
            
            if (board[nextRowOneStep][this.file] == null) {
                possibleMovCoordinateShifs.add(new ValidateCoordinate(nextRowOneStep, this.file));
            }

            int nextRowTwoSteps = this.runk - 2 * direction;
            if (!this.isMoved && nextRowTwoSteps >= 0 && nextRowTwoSteps < board.length) {
                if ( board[nextRowTwoSteps][this.file] == null ) {
                    possibleMovCoordinateShifs.add(new ValidateCoordinate(nextRowTwoSteps, this.file));
                    }
                }
            }
        
        int diagLeftRow = this.runk - direction;
        int diagLeftCol = this.file - 1;

        // left
        if (diagLeftRow >= 0 && diagLeftRow < board.length && diagLeftCol >= 0 && diagLeftCol < board.length) {
            Figure targetPiece = board[diagLeftRow][diagLeftCol];
            if (targetPiece != null && targetPiece.getColor() != this.color) {
                   possibleMovCoordinateShifs.add(new ValidateCoordinate(diagLeftRow, diagLeftCol));

            }
        }
    
        // right
        int diagRightRow = this.runk - direction;
        int diagRightCol = this.file + 1;

        if (diagRightRow >= 0 && diagRightRow < board.length && diagRightCol >= 0 && diagRightCol < board.length) {
            Figure targetPiece = board[diagRightRow][diagRightCol];
            if (targetPiece != null && targetPiece.getColor() != this.color) {
                possibleMovCoordinateShifs.add(new ValidateCoordinate(diagRightRow, diagRightCol));
            }
        }
        // TODO сделать проверку взятия на проходе
        return possibleMovCoordinateShifs;
    }

   
}
