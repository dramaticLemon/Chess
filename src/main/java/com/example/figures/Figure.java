package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import com.example.Coordinates;
import com.example.CoordinatesShift;
import com.example.FigureType;
import com.example.board.Board;
import com.example.config.Color;

public abstract class Figure {
    public Coordinates coordinate;
    public final Color color;
    public FigureType figureType;

    public Figure(Coordinates coordinate, Color color) {
        this.coordinate = coordinate;
        this.color = color;
    }
    
    public Color getColor() {  
        return this.color;
    }

    public Set<Coordinates> getPossibleMooves(Board board) {
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift : getFigureMoves()) {
            if (coordinate.canShift(shift)) {
                Coordinates newCoordinates = coordinate.shift(shift);

                if (isSquareAvialableForMove(newCoordinates, board)) {
                    result.add(newCoordinates);
                }
            }
        }

        return result;
    }

    protected abstract Set<CoordinatesShift> getFigureMoves();

    protected boolean isSquareAvialableForMove(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates) || Board.getFigureAt(coordinate).color != this.color;
    }


    protected Set<CoordinatesShift> getFigureAttack() {
        return getFigureMoves();
    }

    public Set<Coordinates> getAttackedSquares(Board board) {
        Set<CoordinatesShift> figureAttacks = getFigureAttack();
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift figureAttack : figureAttacks) {
            if (coordinate.canShift(figureAttack)) {
                Coordinates shiftedCoordinates = coordinate.shift(figureAttack);

                if (isSquareAvailableForAttack(shiftedCoordinates, board)) {
                    result.add(shiftedCoordinates);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForAttack(Coordinates shiftedCoordinates, Board board) {
        return true;
    }


}
