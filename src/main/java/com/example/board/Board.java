package com.example.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.ConfigService;
import com.example.figures.Figure;

public class Board {
    private static Board instance;
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);
    Figure[][] board = new Figure[8][8];

    public static Board getInstance() {
        if (instance == null) {
            logger.info("Initital Board object");
            instance = new Board();
        }
        return instance;
    }
}
