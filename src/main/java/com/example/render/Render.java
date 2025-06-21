package com.example.render;

import java.util.Map;
import java.util.Set;

import com.example.Coordinate;
import com.example.FigureType;
import com.example.config.Color;

public interface Render {
    public void render();
    public void renderCoordinate(Set<Coordinate> possibleCoordinate);
    public void renderLoseFigure(Map<FigureType, Integer> map, Color color);
}
