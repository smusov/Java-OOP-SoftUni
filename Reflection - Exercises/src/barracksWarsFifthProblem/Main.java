package barracksWarsFifthProblem;

import barracksWarsFifthProblem.core.Engine;
import barracksWarsFifthProblem.core.commands.CommandInterpreterImpl;
import barracksWarsFifthProblem.core.factories.UnitFactoryImpl;
import barracksWarsFifthProblem.data.UnitRepository;
import barracksWarsFifthProblem.interfaces.CommandInterpreter;
import barracksWarsFifthProblem.interfaces.Repository;
import barracksWarsFifthProblem.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {

        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter interpreter = new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(interpreter);

        engine.run();

    }
}
