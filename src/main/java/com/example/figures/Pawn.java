package com.example.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.config.Color;

public class Pawn extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Pawn.class);

    public Pawn(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = 'P';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.debug("Pawn is move");
            this.x = coordinate.getColumn();
            this.y = coordinate.getRow();
    }
    
}
