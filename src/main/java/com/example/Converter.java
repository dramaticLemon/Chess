package com.example;

public class Converter {
    public static int[] convertToCoordinates(char fileChar, char rankChar) {
        int row = 8 - (rankChar - '0');   
        int col = fileChar - 'a';   
        return new int[] { row, col }; // swaping X Y coordinates
    }
}
