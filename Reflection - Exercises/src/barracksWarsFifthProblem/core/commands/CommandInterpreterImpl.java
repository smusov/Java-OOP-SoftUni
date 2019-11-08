package barracksWarsFifthProblem.core.commands;

import barracksWarsFifthProblem.interfaces.CommandInterpreter;
import barracksWarsFifthProblem.interfaces.Executable;
import barracksWarsFifthProblem.interfaces.Repository;
import barracksWarsFifthProblem.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PACKAGE_NAME = "barracksWarsFifthProblem.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String className = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);

        Executable executable = null;

        try {

            Class clazz = Class.forName(COMMANDS_PACKAGE_NAME + className);

            Constructor constructor = clazz.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            executable = (Executable) constructor.newInstance((Object) data);

            injectsField(executable);

        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException
                | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return executable;
    }

    private void injectsField(Executable executable) {

        Field[] declaredField = executable.getClass().getDeclaredFields();
        Field[] declaredFields = this.getClass().getDeclaredFields();

        for (Field exField : declaredField) {
            if (exField.getAnnotations()[0].toString().contains("Inject")){
                for (Field curField : declaredFields) {
                    if (curField.getType().equals(exField.getType())){
                        exField.setAccessible(true);
                        try {
                            exField.set(executable,curField.get(this));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
