package com.example;


import java.util.List;

import com.example.board.Board;
import com.example.board.Move;
import com.example.config.Color;
import com.example.render.BoardConsoleRenderer;


public class Game {
    private final Board board;
    private final BoardConsoleRenderer render = new BoardConsoleRenderer();

    private final List<GameStateChecker> checkers = List.of(
        new StatemateGameStateChecker(),
        new CheckMateGameStateChecker()
    );

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        Color colorToMove = Color.WHITE;
        GameState state = determineGameState(board, colorToMove);
        // board.setutDefaulFigurePositons();
        while (state == GameState.ONGOING) { 
            render.render(board);
            
            if (colorToMove == Color.WHITE) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }

            Move move =  ConsoleCommandHandler.imputMove(board, colorToMove, render);
            board.makeMove(move); // обновить саму доску
            colorToMove = colorToMove.swap();
        }
        render.render(board);
        System.out.println("The game ended");
    }

   private GameState determineGameState(Board board, Color color) {
        for (GameStateChecker checker : checkers) {
            GameState state = checker.check(board, color);

            if (state != GameState.ONGOING) {
                return state;
            }
        }
        return GameState.ONGOING;
   }
}
