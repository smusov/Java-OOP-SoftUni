package appenders;

import enums.ReportLevel;
import interfaces.File;
import interfaces.Layout;
import logFiles.LogFile;

public class FileAppender extends AppenderImpl {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (this.file == null) {
            throw new NullPointerException("No set file!");
        }
        if (super.canAppend(reportLevel)) {

            super.increaseMessagesCount();

            this.file.append(super.getLayout().format(time, message, reportLevel));

            this.file.write();
        }

    }

    @Override
    public String toString() {
        return super.toString() + String.format(", File size: %d", this.file.getSize());
    }
}
