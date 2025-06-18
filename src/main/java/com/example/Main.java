package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.ConfigService;
import com.example.render.ConsoleRenderingBoard;
import com.example.render.Render;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(ConfigService.class);

    public static void main(String[] args) {
        logger.info("run program");
        Render render = new ConsoleRenderingBoard();
        render.render();
    }
}