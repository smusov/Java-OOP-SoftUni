package barracksWarsFourthProblem;

import barracksWarsFourthProblem.core.Engine;
import barracksWarsFourthProblem.core.factories.UnitFactoryImpl;
import barracksWarsFourthProblem.data.UnitRepository;
import barracksWarsFourthProblem.interfaces.Repository;
import barracksWarsFourthProblem.interfaces.Runnable;
import barracksWarsFourthProblem.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {

        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository,unitFactory);

        engine.run();

    }
}
