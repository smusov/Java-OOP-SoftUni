package core.commands;

import core.commands.CommandImpl;

import java.util.List;

public class Analyze extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        return this.database.getAnalyse();
    }
}
