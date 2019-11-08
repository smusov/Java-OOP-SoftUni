package barracksWarsFifthProblem.core.factories;

import barracksWarsFifthProblem.interfaces.Unit;
import barracksWarsFifthProblem.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWarsFifthProblem.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        Unit unit = null;

        try {
            Class clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);

            unit = (Unit) clazz.getConstructor().newInstance();


        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
