package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.FigureType;
import com.example.ValidateCoordinate;
import com.example.board.UnmodifiableBoardView;
import com.example.config.Color;


public class Pawn extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Pawn.class);
    private boolean isMoved;

    public Pawn(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk; 
        this.color = color;
        this.type = FigureType.PAWN;
        this.isMoved = false;
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.info("Pawn is move");
        if (!this.isMoved) {
            this.isMoved = true;
        }
        setCoordinate(coordinate);
    }

    private void setCoordinate(Coordinate coordinate) {
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }
 
    @Override
    public Set<Coordinate> getPossibleMooves(UnmodifiableBoardView board) {
        Set<Coordinate> possibleMovCoordinateShifs = new HashSet<>();
    
        int direction = (this.color == Color.WHITE) ? 1 : -1;
        int nextRowOneStep = this.runk - direction;

        if (nextRowOneStep >= 0 && nextRowOneStep < board.getHeight()) {
            
            if (board.get(this.file, nextRowOneStep) == null) {
                possibleMovCoordinateShifs.add(new ValidateCoordinate(nextRowOneStep, this.file));
            }

                    int nextRowTwoSteps = this.runk - 2 * direction;
            if (!this.isMoved && nextRowTwoSteps >= 0 && nextRowTwoSteps < board.getHeight()) {
                if (board.get(this.file, nextRowOneStep)  == null ) {
                    possibleMovCoordinateShifs.add(new ValidateCoordinate(nextRowTwoSteps, this.file));
                    }
                }
            }
        
        int diagLeftRow = this.runk - direction;
        int diagLeftCol = this.file - 1;

        // left
        if (diagLeftRow >= 0 && diagLeftRow < board.getHeight() && diagLeftCol >= 0 && diagLeftCol < board.getHeight()) {
            Figure targetPiece = board.get(diagLeftCol, diagLeftRow);
            if (targetPiece != null && targetPiece.getColor() != this.color) {
                   possibleMovCoordinateShifs.add(new ValidateCoordinate(diagLeftRow, diagLeftCol));

            }
        }
        // right
        int diagRightRow = this.runk - direction;
        int diagRightCol = this.file + 1;

        if (diagRightRow >= 0 && diagRightRow < board.getHeight() && diagRightCol >= 0 && diagRightCol < board.getHeight()) {
            Figure targetPiece = board.get(diagRightCol, diagRightRow);
            if (targetPiece != null && targetPiece.getColor() != this.color) {
                possibleMovCoordinateShifs.add(new ValidateCoordinate(diagRightRow, diagRightCol));
            }
        }
        // сделать взятия на проходе
        return possibleMovCoordinateShifs;
    }

   
}
