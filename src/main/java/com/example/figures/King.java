package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.board.UnmodifiableBoardView;
import com.example.config.Color;

public class King extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(King.class);

    public King(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'K';
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
    public Set<Coordinate> getPossibleMooves(UnmodifiableBoardView board) {
        Set<Coordinate> posibleMove = new HashSet<>();

        int rows = board.getHeight();
        int cols = board.getWidth();
        
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1,0}, {1, 1}};
        

        for (int[] direction : directions) {
            int dr = direction[0];
            int dc = direction[1];
            
            int c = this.file + dr;
            int r = this.runk + dc;

            if (r >= 0 && r < rows && c >= 0 && c < cols) {
                if (board.get(c, r) == null) {
                    posibleMove.add(new ValidateCoordinate(r, c));
                }
                else {
                    if (board.get(c, r).color != this.color) {
                        posibleMove.add(new ValidateCoordinate(r, c));
                    }
                }
            }
        }
        return posibleMove;
    }
}
