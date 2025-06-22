package com.example.render;


import static java.util.Collections.emptySet;
import java.util.Map;
import java.util.Set;

import com.example.Coordinates;
import com.example.FigureType;
import com.example.File;
import com.example.board.Board;
import com.example.config.Color;
import com.example.figures.Figure;

public class BoardConsoleRenderer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[45m";


    private static final Map<FigureType, String> WHITE_SYMBOLS = Map.of(
        FigureType.PAWN, "♙",
        FigureType.KNIGHT, "♘",
        FigureType.BISHOP, "♗",
        FigureType.ROOK, "♖",
        FigureType.QUEEN, "♕",
        FigureType.KING, "♔"

    );

    private static final Map<FigureType, String> BLACK_SYMBOLS = Map.of(
        FigureType.PAWN, "♟",
        FigureType.KNIGHT, "♞",
        FigureType.BISHOP, "♝",
        FigureType.ROOK, "♜",
        FigureType.QUEEN, "♛",
        FigureType.KING, "♚"
    );

    public void render(Board board, Figure pieceToMove) {
        Set<Coordinates> availableMoveSquares = emptySet();
        if (pieceToMove != null) {
            availableMoveSquares = pieceToMove.getPossibleMooves(board);
        }
        System.out.println(" A  B  C  D  E  F  G  H");
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                boolean isHighlight = availableMoveSquares.contains(coordinates);

                if (board.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates, isHighlight);
                } else {
                    line += getPieceSprite(Board.getFigureAt(coordinates), isHighlight);
                }
            }

            line += ANSI_RESET;
            line = line + " " + rank;
            System.out.println(line);
        }
    }

    public void render(Board board) {
        render(board, null);
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean isHighlight) {
        // format = background color + font color + text
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isHighlight) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND + result;
        } else if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }

        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean isHighlight) {
        return colorizeSprite("   ", Color.WHITE, Board.isSquareDark(coordinates), isHighlight);
    }

    private String selectUnicodeSpriteForFigure(Figure figure) {
    return figure.getColor() == Color.WHITE
        ? WHITE_SYMBOLS.get(figure.figureType)
        : BLACK_SYMBOLS.get(figure.figureType);
}

    private String getPieceSprite(Figure figure, boolean isHighlight) {
        return colorizeSprite(
                " " + selectUnicodeSpriteForFigure(figure) + " ", figure.getColor(), Board.isSquareDark(figure.coordinate),
                isHighlight
        );
    }
}