package core.commands.interfaces;

import core.databases.interfaces.DumpHardwareDatabase;

import java.util.List;

public interface Command {
    String execute(List<String> args);

    void setDatabase(DumpHardwareDatabase database);
}
