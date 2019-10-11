package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> passedBorder = new ArrayList<>();

        String input;

        while (!"End".equals(input = read.readLine())) {

            String[] data = input.split("\\s+");

            if (data.length > 2) {
                passedBorder.add(new Citizen(data[0], Integer.parseInt(data[1]), data[2]));
            } else {
                passedBorder.add(new Robot(data[1], data[0]));
            }


        }

        String fakeId = read.readLine();

        passedBorder.stream().filter(e->e.getId().endsWith(fakeId)).forEach(e->System.out.println(e.getId()));
    }
}
