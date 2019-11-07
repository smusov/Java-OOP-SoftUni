package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

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
