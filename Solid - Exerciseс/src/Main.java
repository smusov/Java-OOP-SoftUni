import controllers.EngineImp;
import controllers.InputParser;
import factories.LoggerFactory;
import interfaces.Engine;
import interfaces.Factory;
import interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        InputParser inputParser = new InputParser();

        Logger logger = Main.LOGGER_FACTORY.produce(inputParser.createLoggerInfo(READER));

        Engine engine = new EngineImp(logger);

        engine.run("END", READER);

        System.out.println(logger);

    }
}
