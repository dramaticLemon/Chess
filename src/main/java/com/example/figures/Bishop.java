package com.example.figures;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Coordinate;
import com.example.ValidateCoordinate;
import com.example.config.Color;

public class Bishop extends Figure{
    private static final Logger logger = LoggerFactory.getLogger(Bishop.class);

    public Bishop(int x, int y, Color color) {
        this.file = x;
        this.runk = y;
        this.color = color;
        this.type = 'B';
    }

    @Override
    public void mekeMove(Coordinate coordinate) {
        this.file = coordinate.getColumn();
        this.runk = coordinate.getRow();
    }
    
    @Override
    public Set<Coordinate> getPossibleMooves(Figure[][] board) {
        Set<Coordinate> posibleMove = new HashSet<>();

        int rows = board.length;
        int cols = board[0].length;
        
        // возможные ходы по вертикалям
        int[][] directions = {{-1, 1}, {1, -1}, {-1, -1}, {1, 1}};

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
