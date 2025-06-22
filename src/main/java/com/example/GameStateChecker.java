package com.example;

import com.example.board.Board;
import com.example.config.Color;

public abstract class GameStateChecker {
    public abstract GameState check(Board board, Color color); 
}
