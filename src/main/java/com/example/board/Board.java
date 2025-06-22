package com.example.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.Coordinates;
import com.example.FigureType;
import com.example.File;
import com.example.config.Color;
import com.example.figures.Figure;
import com.example.inititalize.ChessFigureFactory;

public class Board {
    public final String startingFen;
    private final static Map<Coordinates, Figure> figures = new HashMap<>();
    public List<Move> moves = new ArrayList<>();
    // добавить новую фигуру в координату

    public Board(String startinFen) {
        this.startingFen = startinFen;
    }

    public void setFigure(Coordinates coordinate, Figure figure) {
        figure.coordinate = coordinate;
        figures.put(coordinate, figure);
    }

    // получить фигуру по координатам
    public static Figure getFigureAt(Coordinates coordinate) {
        return figures.get(coordinate);
    }

    // проверка что клетка пустая
    /*
     * если такого ключа нету то значит клетка пустая
     */
    public boolean isSquareEmpty(Coordinates coordinate) {
        return !figures.containsKey(coordinate);
    }

    public void setutDefaulFigurePositons()  {


        for (File file: File.values()) {
            Coordinates pawDefaultCootdinatedWhite = new Coordinates(file, 2);
            Coordinates pawDefaultCootdinatedBlack = new Coordinates(file, 7);
            setFigure(pawDefaultCootdinatedWhite, ChessFigureFactory.createFigure(FigureType.PAWN, pawDefaultCootdinatedWhite, Color.WHITE));
            setFigure(pawDefaultCootdinatedBlack, ChessFigureFactory.createFigure(FigureType.PAWN, pawDefaultCootdinatedBlack, Color.BLACK));

        }

        setFigure(new Coordinates(File.A, 1), ChessFigureFactory.createFigure(FigureType.ROOK, new Coordinates(File.A, 1), Color.WHITE));
        setFigure(new Coordinates(File.H, 1), ChessFigureFactory.createFigure(FigureType.ROOK, new Coordinates(File.H, 1), Color.WHITE));
        setFigure(new Coordinates(File.A, 8), ChessFigureFactory.createFigure(FigureType.ROOK, new Coordinates(File.A, 8), Color.BLACK));
        setFigure(new Coordinates(File.H, 8), ChessFigureFactory.createFigure(FigureType.ROOK, new Coordinates(File.H, 8), Color.BLACK));

        // set knights
        setFigure(new Coordinates(File.B, 1), ChessFigureFactory.createFigure(FigureType.KNIGHT, new Coordinates(File.B, 1), Color.WHITE));
        setFigure(new Coordinates(File.G, 1), ChessFigureFactory.createFigure(FigureType.KNIGHT, new Coordinates(File.G, 1), Color.WHITE));
        setFigure(new Coordinates(File.B, 8), ChessFigureFactory.createFigure(FigureType.KNIGHT, new Coordinates(File.B, 8), Color.BLACK));
        setFigure(new Coordinates(File.G, 8), ChessFigureFactory.createFigure(FigureType.KNIGHT, new Coordinates(File.G, 8), Color.BLACK));


        // set bishops
        setFigure(new Coordinates(File.C, 1), ChessFigureFactory.createFigure(FigureType.BISHOP, new Coordinates(File.C, 1), Color.WHITE));
        setFigure(new Coordinates(File.F, 1), ChessFigureFactory.createFigure(FigureType.BISHOP, new Coordinates(File.F, 1), Color.WHITE));
        setFigure(new Coordinates(File.C, 8), ChessFigureFactory.createFigure(FigureType.BISHOP, new Coordinates(File.C, 8), Color.BLACK));
        setFigure(new Coordinates(File.F, 8), ChessFigureFactory.createFigure(FigureType.BISHOP, new Coordinates(File.F, 8), Color.BLACK));
        

        // set queens
        setFigure(new Coordinates(File.D, 1), ChessFigureFactory.createFigure(FigureType.QUEEN, new Coordinates(File.D, 1), Color.WHITE));
        setFigure(new Coordinates(File.D, 8), ChessFigureFactory.createFigure(FigureType.QUEEN, new Coordinates(File.D, 1), Color.BLACK));

        // set kings
        setFigure(new Coordinates(File.E, 1),  ChessFigureFactory.createFigure(FigureType.KING, new Coordinates(File.E, 1), Color.WHITE));
        setFigure(new Coordinates(File.E, 8),  ChessFigureFactory.createFigure(FigureType.KING, new Coordinates(File.E, 8), Color.BLACK));

    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    public void makeMove(Move move) {
        Figure figure = getFigureAt(move.from);
        removeFigure(move.from);
        setFigure(move.to, figure);
        moves.add(move);
        
    }

    private void removeFigure(Coordinates coordinates) {
        figures.remove(coordinates);
    }  


    public List<Figure> getFiguresByColor(Color color) {
        List<Figure> result = new ArrayList<>();

        for (Figure figure : figures.values()) {
            if (figure.color == color) {
                result.add(figure);
            }
        }
        
        return result;
    }

    public boolean isSquareAttakedByCollor(Coordinates coordinates, Color color) {
        List<Figure> figures = getFiguresByColor(color);
        
        for (Figure figure : figures) {
            Set<Coordinates> attackedSquares = figure.getAttackedSquares(this);

            if (attackedSquares.contains(coordinates)) {
                return true;
            }
        }
        return false;
    }
}

