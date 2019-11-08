package barracksWarsFifthProblem.core.commands;


import barracksWarsFifthProblem.anotation.Inject;
import barracksWarsFifthProblem.interfaces.Repository;
import barracksWarsFifthProblem.interfaces.Unit;
import barracksWarsFifthProblem.interfaces.UnitFactory;

public class Add extends Command {

    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];

        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
