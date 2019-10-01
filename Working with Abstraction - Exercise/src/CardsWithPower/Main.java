package CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String rank = read.readLine();
        String suit = read.readLine();

        System.out.println(new Card(rank,suit));

        //System.out.println(new Card(read.readLine(),read.readLine()));
    }
}
