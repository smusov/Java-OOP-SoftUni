package barracksWarsFifthProblem.core.commands;

import barracksWarsFifthProblem.anotation.Inject;
import barracksWarsFifthProblem.interfaces.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unit = super.getData()[1];

        try {
            this.repository.removeUnit(unit);
            return unit + " retired!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
