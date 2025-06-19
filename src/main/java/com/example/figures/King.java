package com.example.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.config.Color;

public class King extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(King.class);

    public King(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = 'K';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        logger.debug("King is move");
    }
    
}
