package core.commands;

import core.commands.interfaces.Command;
import core.databases.interfaces.DumpHardwareDatabase;

import java.util.List;

public abstract class CommandImpl implements Command {

    protected DumpHardwareDatabase database;

    @Override
    public abstract String execute(List<String> args);

    @Override
    public void setDatabase(DumpHardwareDatabase database){
        this.database = database;
    }

}
