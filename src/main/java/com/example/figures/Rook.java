package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.board.UnmodifiableBoardView;
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
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }

    @Override
    public Set<Coordinate> getPossibleMooves(UnmodifiableBoardView board) {

        Set<Coordinate> posibleMove = new HashSet<>();
        int rows = board.getHeight();
        int cols = board.getWidth();
        
        
         int[][] directionsLikeRook = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int[] direction : directionsLikeRook) {
            int dr = direction[0];
            int dc = direction[1];
            
            int r = this.runk + dr;
            int c = this.file + dc;
            
            while (r >= 0 && r < rows && c >= 0 && c < cols) {
                Figure target = board.get(c, r);
                if (target == null) {
                    posibleMove.add(new ValidateCoordinate(r, c));
                } else {
                    if (target.color != this.color) {
                        posibleMove.add(new ValidateCoordinate(r, c));
                    }
                    break;
            }
            r += dr;
            c += dc;
            }
        }

        return posibleMove;
    }
    
}
