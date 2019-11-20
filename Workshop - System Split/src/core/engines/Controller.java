package core.engines;

import core.commands.interfaces.Command;
import core.databases.interfaces.DumpHardwareDatabase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private static final String PATH = "core.commands.";

    private DumpHardwareDatabase database;

    public Controller(DumpHardwareDatabase database) {
        this.database = database;
    }

    public String executeCommand(String args) {

        List<String> data = Arrays.asList(args.split("[\\\\(, )]+"));

        if (data.get(0).equals("System")){
            data.set(0,"SystemSplit");
        }

        String message = "";

        try {

            Class<?> commandClass = Class.forName(PATH + data.get(0));
            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();

            Command command = (Command) declaredConstructor.newInstance();

            command.setDatabase(this.database);

            message = command.execute(data);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return message.trim();
    }
}
