package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.ConfigService;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    public static void main(String[] args) {
        logger.info("run program");
        Game game = new Game();
        game.gemeLoop();
    }
}