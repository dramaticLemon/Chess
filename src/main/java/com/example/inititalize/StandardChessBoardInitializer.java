package com.example.inititalize;

import com.example.config.Color;
import com.example.figures.Bishop;
import com.example.figures.Figure;
import com.example.figures.King;
import com.example.figures.Knight;
import com.example.figures.Pawn;
import com.example.figures.Queen;
import com.example.figures.Rook;

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
        for (int x = 0; x < 8; x++) {
            board[1][x] = new Pawn(x, 1, Color.BLACK);
            board[6][x] = new Pawn(x, 6, Color.WHITE);
        }
    }

    private void initialRook(Figure[][] board) {
        board[0][0] = new Rook(0, 0, Color.BLACK);
        board[0][7] = new Rook(7, 0, Color.BLACK);
        board[7][0] = new Rook(0, 7, Color.WHITE);
        board[7][7] = new Rook(7, 7, Color.WHITE);
    }

    private void initialKnight(Figure[][] board) {
        board[0][1] = new Knight(1, 0, Color.BLACK);
        board[0][6] = new Knight(6, 0, Color.BLACK);
        board[7][1] = new Knight(1, 7, Color.WHITE);
        board[7][6] = new Knight(6, 7, Color.WHITE);
    }

    private void initrialBishop(Figure[][] board) {
        board[0][2] = new Bishop(2, 0, Color.BLACK);
        board[0][5] = new Bishop(5, 0, Color.BLACK);
        board[7][2] = new Bishop(2, 7, Color.WHITE);
        board[7][5] = new Bishop(5, 7, Color.WHITE);
    }

    private void initialQueen(Figure[][] board) {
        board[0][3] = new Queen(3, 0, Color.BLACK);
        board[7][3] = new Queen(3, 7, Color.WHITE);
    }
    
    private void initialKing(Figure[][] board) {
        board[0][4] = new King(4, 0, Color.BLACK);
        board[7][4] = new King(4, 7, Color.WHITE);
    }
}
