package logger.controllers;

import logger.enums.ReportLevel;
import logger.interfaces.Engine;
import logger.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;


public class EngineImp implements Engine {

    private Logger logger;

    public EngineImp(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void run(String stopCommand, BufferedReader reader) throws IOException {

        String input;

        while (!stopCommand.equals(input = reader.readLine())) {

            String[] data = input.split("\\|");

            ReportLevel reportLevel = ReportLevel.valueOf(data[0]);
            String time = data[1];
            String message = data[2];

            this.logger.log(time, message, reportLevel);

        }
    }
}
