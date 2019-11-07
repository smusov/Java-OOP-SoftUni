package barracksWarsFourthProblem.core.commands;

import barracksWarsFourthProblem.interfaces.Repository;
import barracksWarsFourthProblem.interfaces.Unit;
import barracksWarsFourthProblem.interfaces.UnitFactory;

public class Add extends Command {


    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];

        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);

        return unitType + " added!";
    }
}
