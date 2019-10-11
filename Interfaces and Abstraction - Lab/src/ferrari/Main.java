package ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));

        Car ferrari = new Ferrari(read.readLine());

        System.out.println(ferrari);

    }
}