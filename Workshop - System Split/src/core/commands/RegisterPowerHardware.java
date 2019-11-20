package core.commands;

import factories.HardwareFactory;

import java.util.List;

public class RegisterPowerHardware extends CommandImpl {

    @Override
    public String execute(List<String> args) {

        this.database.registerHardware(
                        HardwareFactory.makePowerHardware(args.get(1), Integer.parseInt(args.get(2)), Integer.parseInt(args.get(3))));

        return "";
    }
}
