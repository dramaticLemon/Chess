package com.example.render;

import java.util.Set;

import com.example.Coordinate;

public interface Render {
    public void render();
    public void renderCoordinate(Set<Coordinate> possibleCoordinate);
}
