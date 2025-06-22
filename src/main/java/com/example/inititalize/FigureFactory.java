package com.example.inititalize;

import com.example.Coordinates;
import com.example.config.Color;
import com.example.figures.Figure;

@FunctionalInterface
interface FigureFactory {
    Figure create(Coordinates coordinate, Color color);
}
