package core.commands;

import java.util.List;

public class Destroy extends CommandImpl {
    @Override
    public String execute(List<String> args) {

        super.database.destroyHardware(args.get(1));

        return "";
    }
}
