package com.example.figures;

import com.example.Coordinate;
import com.example.config.Color;

public abstract class Figure {
    int x;
    int y;
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

}
