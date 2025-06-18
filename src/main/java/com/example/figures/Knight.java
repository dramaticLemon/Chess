package com.example.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.Color;

public class Knight extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Knight.class);

    public Knight(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    void mekeMove() {
        logger.debug("Knight is move");
    }
}
