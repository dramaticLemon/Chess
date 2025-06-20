package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.config.Color;

public class Knight extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Knight.class);

    public Knight(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'N';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }

   @Override
    public Set<Coordinate> getPossibleMooves(Figure[][] board) {
        Set<Coordinate> posibleMove = new HashSet<>();
        return posibleMove;
    }
}
