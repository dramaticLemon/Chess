package com.example.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.Color;

public class Rook extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Rook.class);

    public Rook(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = 'R';
    }

    @Override
    void mekeMove() {
        logger.debug("Rook is move");
    }
    
}
