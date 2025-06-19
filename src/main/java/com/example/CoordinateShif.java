package com.example;


/**
 * toString  - отображение координат в виде шахматной нотации
 */
public class CoordinateShif {
    private final int rankShift;
    private final int fileShift;
    
    public CoordinateShif( int rankShift ,int fileShift) {
        this.rankShift = rankShift;
        this.fileShift = fileShift;
    }

    @Override
    public String toString() {
        char fileChar = (char) ('a' + rankShift);   
        int rankNum = 8 - fileShift;              
        return "" + fileChar + rankNum;
}
}
