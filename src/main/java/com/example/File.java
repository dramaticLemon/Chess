package com.example;

public enum File {
    A, B, C, D, E, F, G, H;

    public static File fromChar(char c) {
        try {
            // перевести чар в строки и в верхний регист, попытаться вернуть такое значение 
            return File.valueOf(String.valueOf(c).toUpperCase());
        } catch (IllegalArgumentException e) {
            // если такого значения нету то вернуть null
            return null;
        }
    }
}