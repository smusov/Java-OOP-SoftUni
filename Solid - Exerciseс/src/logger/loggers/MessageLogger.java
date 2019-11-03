package logger.loggers;

import logger.interfaces.Logger;
import logger.enums.ReportLevel;
import logger.interfaces.Appender;

import java.util.Arrays;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void log(String time, String message, ReportLevel reportLevel) {
        for (Appender appender : this.appenders) {
            appender.append(time, message, reportLevel);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info");

        Arrays.stream(this.appenders).forEach(e -> builder.append(System.lineSeparator()).append(e.toString()));

        return builder.toString();
    }
}
