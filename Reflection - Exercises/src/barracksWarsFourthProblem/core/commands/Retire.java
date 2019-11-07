package barracksWarsFourthProblem.core.commands;

import barracksWarsFourthProblem.interfaces.Repository;
import barracksWarsFourthProblem.interfaces.UnitFactory;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unit = super.getData()[1];

        try {
            super.getRepository().removeUnit(unit);
            return unit + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
