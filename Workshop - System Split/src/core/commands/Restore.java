package core.commands;

import java.util.List;

public class Restore extends CommandImpl {
    @Override
    public String execute(List<String> args) {

        super.database.restoreHardware(args.get(1));

        return "";
    }
}
