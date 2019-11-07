package barracksWarsFourthProblem.core;

import barracksWarsFourthProblem.interfaces.Executable;
import barracksWarsFourthProblem.interfaces.Repository;
import barracksWarsFourthProblem.interfaces.Runnable;
import barracksWarsFourthProblem.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    private static final String COMMANDS_PACKAGE_NAME = "barracksWarsFourthProblem.core.commands.";

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);

                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String className = data[0].substring(0, 1).toUpperCase() + data[0].substring(1);

        Class clazz = Class.forName(COMMANDS_PACKAGE_NAME + className);
        Constructor constructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);

        Executable command = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);

        return command.execute();
    }

}
