package com.example;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.board.Board;
import com.example.config.Color;
import com.example.config.ConfigService;
import com.example.figures.Figure;
import com.example.figures.Pawn;
import com.example.render.ConsoleRenderingBoard;
import com.example.render.Render;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    public static void main(String[] args) {
        logger.info("run program");
        // Game game = new Game();
        // game.gemeLoop();

        Pawn pawn1 = new Pawn(1, 1, Color.WHITE);
        Pawn pawn2 = new Pawn(1, 1, Color.WHITE);
        Board board = Board.getInstance();

        Figure[][] f = board.getBoard();

        f[2][0] = pawn1;
        f[2][2] = pawn2;

        Render render = new ConsoleRenderingBoard();
        render.render();
        ConsoleCommandHandler commandHandler = new ConsoleCommandHandler();
        Coordinate coordinate = commandHandler.getInputCoordinate();

        Figure figure = board.getFigureAt(coordinate.getColumn(), coordinate.getRow()); // получить фигуру с матрицы
        Set<CoordinateShif> posibleMove = figure.getPossibleMooves(board.getBoard());
        System.out.println(posibleMove);
    }
}