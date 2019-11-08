package barracksWarsFifthProblem.core;

import barracksWarsFifthProblem.interfaces.CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {

                String input = reader.readLine();
                String[] data = input.split("\\s+");

                String commandName = data[0];

                String result = this.commandInterpreter.interpretCommand(data, commandName).execute();

                if (result.equals("fight")) {
                    break;
                }

                System.out.println(result);

            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
