package core.commands;

import java.util.List;

public class SystemSplit extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        return this.database.getSystemSplit();
    }
}
