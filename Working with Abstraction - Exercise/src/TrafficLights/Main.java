package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] input = read.readLine().split("\\s+");

        int n = Integer.parseInt(read.readLine());

        Lights[] lights = new Lights[input.length];

        for (int i = 0; i < input.length; i++) {
            lights[i] = Lights.valueOf(input[i]);
        }

        for (int i = 0; i < n; i++) {

            Lights [] newLights = new Lights[lights.length];

            for (int j = 0; j < input.length; j++) {

                if (lights[j].equals(Lights.RED)){
                    newLights[j] = Lights.GREEN;
                }else if (lights[j].equals(Lights.GREEN)){
                    newLights[j] = Lights.YELLOW;
                }else {
                    newLights[j] = Lights.RED;
                }
            }

            lights = newLights;

            printLights(lights);
        }

    }

    private static void printLights(Lights[] lights) {
        for (Lights light : lights) {
            System.out.print(light+" ");
        }
        System.out.println();
    }
}
