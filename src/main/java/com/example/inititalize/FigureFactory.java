package com.example.inititalize;

import com.example.config.Color;
import com.example.figures.Figure;

@FunctionalInterface
interface FigureFactory {
    Figure create(int x, int y, Color color);
}
