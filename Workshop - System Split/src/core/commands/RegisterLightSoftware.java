package core.commands;

import core.commands.CommandImpl;
import factories.SoftwareFactory;

import java.util.List;

public class RegisterLightSoftware extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        this.database.registerSoftware(
                args.get(1), SoftwareFactory.makeLightSoftware(args.get(2),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4))));

        return "";
    }
}
