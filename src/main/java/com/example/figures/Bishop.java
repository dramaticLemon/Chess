package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.CoordinateShif;
import com.example.config.Color;

public class Bishop extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Bishop.class);

    public Bishop(int x, int y, Color color) {
        this.file = x;
        this.runk = y;
        this.color = color;
        this.type = 'B';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.debug("Bishop is move");
    }
    
    @Override
    public Set<CoordinateShif> getPossibleMooves(Figure[][] board) {
        Set<CoordinateShif> posibleMove = new HashSet<>();
        return posibleMove;
    }
    
}
