package com.example.inititalize;

import com.example.ChessFigureFactory;
import com.example.FigureType;
import com.example.config.Color;
import com.example.figures.Figure;

public class StandardChessBoardInitializer implements ChessBoardInitializer {

    @Override
    public void initialize(Figure[][] board) {
        // Pawns
        initialPawn(board);

        // Rooks
        initialRook(board);

        // Knights
        initialKnight(board);

        // Bishops
        initrialBishop(board);

        // Queens
        initialQueen(board);

        // Kings
        initialKing(board);
    }

    private void initialPawn(Figure[][] board) {
        for (int row = 0; row < 8; row++) {
            board[1][row] = ChessFigureFactory.createFigure(FigureType.PAWN, row, 1, Color.BLACK);
            board[6][row] = ChessFigureFactory.createFigure(FigureType.PAWN, row, 6, Color.WHITE);
        }
    }

    private void initialRook(Figure[][] board) {
        board[0][0] = ChessFigureFactory.createFigure(FigureType.ROOK, 0, 0, Color.BLACK);
        board[0][7] = ChessFigureFactory.createFigure(FigureType.ROOK, 7, 0, Color.BLACK);
        board[7][0] = ChessFigureFactory.createFigure(FigureType.ROOK, 0, 7, Color.WHITE);
        board[7][7] = ChessFigureFactory.createFigure(FigureType.ROOK, 7, 7, Color.WHITE);
    }

    private void initialKnight(Figure[][] board) {
        board[0][1] = ChessFigureFactory.createFigure(FigureType.KNIGHT, 1, 0, Color.BLACK);
        board[0][6] = ChessFigureFactory.createFigure(FigureType.KNIGHT, 6, 0, Color.BLACK);
        board[7][1] = ChessFigureFactory.createFigure(FigureType.KNIGHT, 1, 7, Color.WHITE);
        board[7][6] = ChessFigureFactory.createFigure(FigureType.KNIGHT, 6, 7, Color.WHITE);

    }

    private void initrialBishop(Figure[][] board) {
        board[0][2] = ChessFigureFactory.createFigure(FigureType.BISHOP, 2, 0, Color.BLACK);
        board[0][5] = ChessFigureFactory.createFigure(FigureType.BISHOP, 5, 0, Color.BLACK);
        board[7][2] = ChessFigureFactory.createFigure(FigureType.BISHOP, 2, 7, Color.WHITE);
        board[7][5] = ChessFigureFactory.createFigure(FigureType.BISHOP, 5, 7, Color.WHITE);
        
    }

    private void initialQueen(Figure[][] board) {
        board[0][3] = ChessFigureFactory.createFigure(FigureType.QUEEN, 3, 0, Color.BLACK);
        board[7][3] = ChessFigureFactory.createFigure(FigureType.QUEEN, 3, 7, Color.WHITE);
    }
    
    private void initialKing(Figure[][] board) {
        board[0][4] = ChessFigureFactory.createFigure(FigureType.KING, 4, 0, Color.BLACK);
        board[7][4] = ChessFigureFactory.createFigure(FigureType.KING, 4, 7, Color.WHITE);
    }
}
