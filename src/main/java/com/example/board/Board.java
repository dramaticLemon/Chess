package com.example.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.ConfigService;
import com.example.figures.Figure;
import com.example.inititalize.ChessBoardInitializer;
import com.example.inititalize.StandardChessBoardInitializer;

public class Board {
    private static Board instance;
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);
    private static final int WIDTH_BOARD = 8;
    private static final int HEIGHT_BOARD = 8;

    private final Figure[][] board;

    private Board() {
        logger.info("Initial Board object");
        board = new Figure[HEIGHT_BOARD][WIDTH_BOARD];
        ChessBoardInitializer initializer = new StandardChessBoardInitializer();
        initializer.initialize(board);
    }
    
     public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    private static boolean isValidCoordinate(int coord) {
        return coord >= 0 && coord <= 8;
    }

    public Figure getFigureAt(int x, int y) {
        if (isValidCoordinate(x) && isValidCoordinate(y)) {
            return board[y][x];
        }
        throw new IllegalArgumentException("Cannot place figure: Coordinates " + x + ", " + y + " are out of board bounds.");
    }
}
