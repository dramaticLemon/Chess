package com.example.figures;

import java.util.Set;

import com.example.Coordinate;
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

    @SuppressWarnings("unused")
    abstract public void mekeMove(Coordinate coordinate);

    abstract public Set<Coordinate> getPossibleMooves(Figure[][] board);

}
