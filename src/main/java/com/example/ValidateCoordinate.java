package com.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Вводные координаты + валидация
 * Y X 
 * y - выбираем букву
 * х - выбираем цифру
 */
class ValidateCoordinate implements Coordinate{
    private int row; // horizontal
    private int col; // vertical
    private static final Logger logger = LoggerFactory.getLogger(ValidateCoordinate.class);
    private final static char[] VALID_Y_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public ValidateCoordinate(char fileChar , char rankChar ) {
        if (rankChar < '1' || rankChar > '8') {
            logger.error("X coordinate must be between 1 and 8, got " + rankChar);
            throw new IllegalArgumentException("X coordinate must be between 1 and 8.");
        }
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
        int[] arr = Converter.convertToCoordinates(fileChar, rankChar);
        this.row = arr[0];
        this.col = arr[1];
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
        return String.format("matrix[%d][%d]", row, col);
    }
} 
