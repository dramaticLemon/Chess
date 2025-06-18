package com.example.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.Color;
import com.example.config.ConfigService;
import com.example.figures.Bishop;
import com.example.figures.Figure;
import com.example.figures.King;
import com.example.figures.Knight;
import com.example.figures.Pawn;
import com.example.figures.Queen;
import com.example.figures.Rook;

public class Board {
    private static Board instance;
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);
    private static final int WIDTH_BOARD = 8;
    private static final int HEIGHT_BOARD = 8;

    private final Figure[][] board;

    private Board() {
        logger.info("Initial Board object");
        board = new Figure[HEIGHT_BOARD][WIDTH_BOARD];

        // Пешки
        for (int x = 0; x < 8; x++) {
            board[1][x] = new Pawn(x, 1, Color.BLACK);
            board[6][x] = new Pawn(x, 6, Color.WHITE);
        }

        // Ладьи
        board[0][0] = new Rook(0, 0, Color.BLACK);
        board[0][7] = new Rook(7, 0, Color.BLACK);
        board[7][0] = new Rook(0, 7, Color.WHITE);
        board[7][7] = new Rook(7, 7, Color.WHITE);

        // Кони
        board[0][1] = new Knight(1, 0, Color.BLACK);
        board[0][6] = new Knight(6, 0, Color.BLACK);
        board[7][1] = new Knight(1, 7, Color.WHITE);
        board[7][6] = new Knight(6, 7, Color.WHITE);

        // Слоны
        board[0][2] = new Bishop(2, 0, Color.BLACK);
        board[0][5] = new Bishop(5, 0, Color.BLACK);
        board[7][2] = new Bishop(2, 7, Color.WHITE);
        board[7][5] = new Bishop(5, 7, Color.WHITE);

        // Ферзи
        board[0][3] = new Queen(3, 0, Color.BLACK);
        board[7][3] = new Queen(3, 7, Color.WHITE);

        // Короли
        board[0][4] = new King(4, 0, Color.BLACK);
        board[7][4] = new King(4, 7, Color.WHITE);
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public Figure[][] getBoardDesk() {
        return this.board;
    }

    public Figure getFigureAt(int x, int y) {
        if (x < 0 || x >= WIDTH_BOARD || y < 0 || y >= HEIGHT_BOARD) return null;
        return board[y][x];
    }
}
