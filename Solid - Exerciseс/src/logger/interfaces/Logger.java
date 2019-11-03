package logger.interfaces;

import logger.enums.ReportLevel;

public interface Logger {
    void log(String time, String message, ReportLevel reportLevel);

}
