package core.commands;

import core.commands.CommandImpl;
import factories.HardwareFactory;

import java.util.List;

public class RegisterHeavyHardware extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        this.database.registerHardware(
                HardwareFactory.makeHeavyHardware(args.get(1), Integer.parseInt(args.get(2)), Integer.parseInt(args.get(3))));

        return "";
    }
}
