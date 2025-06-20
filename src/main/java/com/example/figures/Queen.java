package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.board.UnmodifiableBoardView;
import com.example.config.Color;

public class Queen extends Figure{

    public Queen(int file, int runk, Color color) {
        this.file = file;
        this.runk = runk;
        this.color = color;
        this.type = 'Q';
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
        
        
        
        int[][] directionsLikeBishop = {{-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

        for (int[] direction : directionsLikeBishop) {
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
