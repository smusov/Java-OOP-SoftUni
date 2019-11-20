package core.commands;

import core.commands.CommandImpl;

import java.util.List;

public class DumpAnalyze extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        return this.database.getDumpAnalyse();
    }
}
