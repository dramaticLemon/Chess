package com.example.figures;

import com.example.config.Color;

public abstract class Figure {
    int x;
    int y;
    Color color;

    @SuppressWarnings("unused")
    abstract void mekeMove();

}
