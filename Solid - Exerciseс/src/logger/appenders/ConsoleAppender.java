package logger.appenders;

import logger.enums.ReportLevel;
import logger.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.canAppend(reportLevel)) {
            super.increaseMessagesCount();
            System.out.println(super.getLayout().format(time, message, reportLevel));
        }
    }
}
