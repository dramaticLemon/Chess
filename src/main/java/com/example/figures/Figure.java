package com.example.figures;

import java.util.Set;

import com.example.Coordinate;
import com.example.board.UnmodifiableBoardView;
import com.example.config.Color;

public abstract class Figure {
    int file;
    int runk;
    Color color;
    char type;

    public char getType() {
        return this.type;
    };

    public Color getColor() {
        return this.color;
    }

    abstract public void mekeMove(Coordinate coordinate);

    abstract public Set<Coordinate> getPossibleMooves(UnmodifiableBoardView board);

}
