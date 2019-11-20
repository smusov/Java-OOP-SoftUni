package core.commands;

import java.util.List;

public class Dump extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        this.database.dumpHardware(args.get(1));
        return "";
    }
}
