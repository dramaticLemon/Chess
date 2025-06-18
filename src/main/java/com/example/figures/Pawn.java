package com.example.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.Color;

public class Pawn extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Pawn.class);

    public Pawn(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    void mekeMove() {
        logger.debug("Pawn is move");
    }
}
