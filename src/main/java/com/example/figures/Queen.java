package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.config.Color;

public class Queen extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Queen.class);

    public Queen(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'Q';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.debug("Queen is move");
    }
    
    @Override
    public Set<Coordinate> getPossibleMooves(Figure[][] board) {
        Set<Coordinate> posibleMove = new HashSet<>();
        return posibleMove;
    }
}
