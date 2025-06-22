package com.example;

import java.util.List;
import java.util.Set;

import com.example.board.Board;
import com.example.config.Color;
import com.example.figures.Figure;

public class StatemateGameStateChecker extends GameStateChecker{

    @Override
    public GameState check(Board board, Color color) {
        List<Figure> figures = board.getFiguresByColor(color);

        for (Figure figure: figures) {
            Set<Coordinates> posibleMoveSquares = figure.getPossibleMooves(board);

            if (!posibleMoveSquares.isEmpty() ) {
                return GameState.ONGOING;
            }
        }
        return GameState.STALEMATE;
    }
    
}
