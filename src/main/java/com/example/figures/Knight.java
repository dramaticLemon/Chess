package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.config.Color;

public class Knight extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Knight.class);

    public Knight(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'N';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    private void setCoordinate(Coordinate coordinate) {
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }


   @Override
    public Set<Coordinate> getPossibleMooves(Figure[][] board) {
        Set<Coordinate> posibleMove = new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;
        
        int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        

        for (int[] direction : directions) {
            int dr = direction[0];
            int dc = direction[1];
            
            int c = this.file + dr;
            int r = this.runk + dc;

            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (board[r][c] == null) {
                    posibleMove.add(new ValidateCoordinate(r, c));
                }
                else {
                    if (board[r][c].color != this.color) {
                        posibleMove.add(new ValidateCoordinate(r, c));
                    }
                }
            }
        }
        return posibleMove;
    }
}
