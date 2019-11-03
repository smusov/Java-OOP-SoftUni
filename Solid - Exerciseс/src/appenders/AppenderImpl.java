package appenders;

import enums.ReportLevel;
import interfaces.Appender;
import interfaces.Layout;

public abstract class AppenderImpl implements Appender {

    public static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesCount;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL;
    }

    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.reportLevel = reportLevel;
    }

    @Override
    public abstract void append(String time, String message, ReportLevel reportLevel);

    protected Layout getLayout() {
        return layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    protected void increaseMessagesCount() {
        this.messagesCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName()
                , this.layout.getClass().getSimpleName()
                , this.reportLevel.toString(), this.messagesCount);
    }
}
