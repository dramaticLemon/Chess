package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.config.Color;

public class Rook extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Rook.class);

    public Rook(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'R';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        this.runk = coordinate.getColumn();
        this.file = coordinate.getRow();
    }

    @Override
    public Set<Coordinate> getPossibleMooves(Figure[][] board) {
        Set<Coordinate> posibleMove = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] direction : directions) {
            int dr = direction[0];
            int dc = direction[1];
            
            int r = file + dr;
            int c = runk + dc;
            
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (board[r][c] == null) {
                    posibleMove.add(new ValidateCoordinate(r, c));
                }
                else {
                    if (board[r][c].color != this.color) {
                        posibleMove.add(new ValidateCoordinate(r, c));
                        break;

                    }
                }
                r += dr;
                c += dc;
            }
        }
               
        return posibleMove;
    }
    
}
