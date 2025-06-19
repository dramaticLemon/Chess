package com.example;

public class Converter {
    public static int[] convertToCoordinates(char fileChar, char rankChar) {
        int col = fileChar - 'a';   
        int row = 8 - (rankChar - '0');   
        return new int[] { row, col }; // поменять местами, перевести в матричный формат
    }

    public static int[] convertToCoordinates(int file, int rank) {
        int col = file;
        int row = 8 - rank; // 1 → 7, 8 → 0
        return new int[] { row, col };
    }
}

