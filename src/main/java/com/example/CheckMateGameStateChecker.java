/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example;

import java.util.List;
import java.util.Set;

import com.example.board.Board;
import com.example.board.BoardFactory;
import com.example.board.Move;
import com.example.config.Color;
import com.example.figures.Figure;
import com.example.figures.King;

public class CheckMateGameStateChecker extends GameStateChecker{

    public CheckMateGameStateChecker() {
    }

    @Override
    public GameState check(Board board, Color color) {
        Figure king = board.getFiguresByColor(color).stream().filter(figure -> figure instanceof King).findFirst().get();
        if (!board.isSquareAttakedByCollor(king.coordinate, color.swap())) {
            return GameState.ONGOING;
        }

        List<Figure> figures = board.getFiguresByColor(color);

        for (Figure figure: figures) {
            Set<Coordinates> posibleMoveSquares = figure.getPossibleMooves(board);
            
            for (Coordinates coordinates: posibleMoveSquares) {
                Board clone  = new BoardFactory().copy(board);
                clone.makeMove(new Move(figure.coordinate, coordinates));

                Figure cloneKing = clone.getFiguresByColor(color).stream().filter(p -> p instanceof King).findFirst().get();

                if (!clone.isSquareAttakedByCollor(cloneKing.coordinate, color.swap())) {
                    return GameState.ONGOING;
                }
            }
        }

        if (color == Color.WHITE) {
            return GameState.CHECKMATE_TO_WHITE_KING;
        } else {
            return GameState.CHECKMATE_TO_BLACK_KING;
        }
    }

}
