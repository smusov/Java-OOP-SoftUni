package core.commands;

import java.util.List;

public class ReleaseSoftwareComponent extends CommandImpl{
    @Override
    public String execute(List<String> args) {
        this.database.releaseSoftware(args.get(1), args.get(2));
        return "";
    }
}
