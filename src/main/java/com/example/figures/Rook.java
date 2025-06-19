package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.CoordinateShif;
import com.example.config.Color;

public class Rook extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Rook.class);

    public Rook(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'R';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.debug("Rook is move");
    }

    @Override
    public Set<CoordinateShif> getPossibleMooves(Figure[][] board) {
        Set<CoordinateShif> posibleMove = new HashSet<>();
        return posibleMove;
    }
    
}
