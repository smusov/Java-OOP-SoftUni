package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class InputParser {
    private Scanner scanner;

    public InputParser() {
        this.scanner = new Scanner(System.in);
    }

    public String createLoggerInfo(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(reader.readLine()).append(System.lineSeparator());
        }
        return builder.toString();
    }

}
