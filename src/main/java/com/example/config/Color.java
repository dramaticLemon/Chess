package com.example.config;

public enum Color {
    WHITE,
    BLACK;

    public Color swap() {
        return this == WHITE ? BLACK : WHITE;
    }
}
