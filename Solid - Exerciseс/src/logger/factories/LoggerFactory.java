package logger.factories;

import logger.interfaces.Appender;
import logger.interfaces.Factory;
import logger.interfaces.Logger;
import logger.loggers.MessageLogger;

public class LoggerFactory implements Factory<Logger> {

    private AppenderFactory appenderFactory;

    public LoggerFactory() {
        this.appenderFactory = new AppenderFactory();
    }

    @Override
    public Logger produce(String produceData) {
        String[] data = produceData.split(System.lineSeparator());

        Appender[] appenders = new Appender[data.length];

        for (int i = 0; i < data.length; i++) {
            appenders[i] = this.appenderFactory.produce(data[i]);
        }
        return new MessageLogger(appenders);
    }
}
