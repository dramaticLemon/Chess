package com.example.board;

import com.example.figures.Figure;

public class UnmodifiableBoardView {
    private final Figure[][] board;
    
    public UnmodifiableBoardView(Figure[][] board) {
        this.board = board;
    }

    public Figure get(int x, int y) {
        return board[y][x];
    }

    public int getWidth() {
        return board[0].length;
    }

    public int getHeight(){
        return board.length;
    }
}