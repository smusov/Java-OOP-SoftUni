package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int[] coordinates = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeft = new Point(coordinates[0],coordinates[1]);
        Point topRight = new Point(coordinates[2],coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int pointsCount = Integer.parseInt(read.readLine());

        for (int i = 0; i < pointsCount; i++) {
            int[] points = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            System.out.println(rectangle.contains(new Point(points[0], points[1])));

        }

    }
}
