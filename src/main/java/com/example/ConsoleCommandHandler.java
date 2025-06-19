package com.example;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleCommandHandler {
    static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Coordinate.class);

    public Coordinate getInputCoordinate() {
        while (true) { 
            System.out.println("Please enter coordinates (ex. a1)");
            String line = scanner.nextLine();

            if (line.length() != 2) {
                logger.debug("Invalid format");
                continue;
            }
            // d2 file + runk
            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            Coordinate coordinate;
            try {
                // converting to matrix format
                coordinate = new ValidateCoordinate(fileChar, rankChar);
                return coordinate;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
          
        }
    }

}


