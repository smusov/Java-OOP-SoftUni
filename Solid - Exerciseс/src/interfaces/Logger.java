package interfaces;

import enums.ReportLevel;

public interface Logger {
    void log(String time, String message, ReportLevel reportLevel);

}
