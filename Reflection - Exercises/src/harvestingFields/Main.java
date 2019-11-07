package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!"HARVEST".equals(input = read.readLine())) {

            if (!input.equals("all")) {
                ConsoleFieldPrinter.printFieldsByGivenModifier(input, RichSoilLand.class);
            } else {
                ConsoleFieldPrinter.printAllFields(RichSoilLand.class);
            }

        }

    }
}
