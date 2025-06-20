package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ValidateCoordinate implements Coordinate{
    private int row; 
    private int col; 
    private static final Logger logger = LoggerFactory.getLogger(ValidateCoordinate.class);
    private final static char[] VALID_Y_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public ValidateCoordinate(char fileChar , char rankChar ) {
        boolean isValidY = false;
        for (char validChar : VALID_Y_COORDINATES) {
            if (fileChar == validChar) {
                isValidY = true;
                break;
            }
        }
        if (!isValidY) {
            logger.error("Y coordinate must be one of: a, b, c, d, e, f, g, h.Get " + fileChar);
            throw new IllegalArgumentException("Y coordinate must be one of: a, b, c, d, e, f, g, h.");
        }
        if (rankChar < '1' || rankChar > '8') {
            logger.error("X coordinate must be between 1 and 8, got " + fileChar);
            throw new IllegalArgumentException("X coordinate must be between 1 and 8.");
        }
        int[] arr = Converter.convertToCoordinates(fileChar, rankChar);
        this.row = arr[0];
        this.col = arr[1];
    }

    public ValidateCoordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return col;
    }

    @Override
    public String toString() {
        char fileChar = (char) ('a' + col);
        int rankNumber = 8 - row; 

        return String.format("%c%d", fileChar, rankNumber);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + row;
        result = prime * result + col;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ValidateCoordinate other = (ValidateCoordinate) obj;
        if (row == other.row || col == other.col) {
        } else {
            return false;
        }
        return true;
    }

   
    
} 
