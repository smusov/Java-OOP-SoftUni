package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Rectangle rectangle = new Rectangle(coordinates[0],coordinates[1],coordinates[2],coordinates[3]);

        int n = Integer.parseInt(read.readLine());

        for (int i = 0; i < n; i++) {
            int[] points = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Point point = new Point(points[0],points[1]);
            boolean check = rectangle.contains(point);

            System.out.println(check);
        }

    }
}
