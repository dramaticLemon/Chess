package com.example;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Вводные координаты + валидация
 * Y X 
 * y - выбираем букву
 * х - выбираем цифру
 */
class Coordinate {
    private int numberChessCoordinate;
    private char alphaChessCoordinate;
    private static final Logger logger = LoggerFactory.getLogger(Coordinate.class);
    private final static char[] VALID_Y_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public Coordinate(int x , char y ) {
        if (x < 1 || x > 8) {
            logger.error("X coordinate must be between 1 and 8, get " + x);
            throw new IllegalArgumentException("X coordinate must be between 1 and 8.");
        }
        this.numberChessCoordinate = x;

        boolean isValidY = false;
        for (char validChar : VALID_Y_COORDINATES) {
            if (y == validChar) {
                isValidY = true;
                break;
            }
        }
        if (!isValidY) {
            logger.error("Y coordinate must be one of: a, b, c, d, e, f, g, h.Get " + y);
            throw new IllegalArgumentException("Y coordinate must be one of: a, b, c, d, e, f, g, h.");
        }

        this.alphaChessCoordinate = y;
    }


    public int getX() {
        return numberChessCoordinate;
    }

    public char getY() {
        return alphaChessCoordinate;
    }


    @Override
    public String toString() {
        return "(" + this.getX() + ") " + "( " + this.getY() + ")";
    }
    
}3