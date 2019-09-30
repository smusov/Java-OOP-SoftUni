package HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] input = read.readLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);

        Reservation reservation = new Reservation(pricePerDay,days,Seasons.valueOf(input[2]),Discount.valueOf(input[3]));

        System.out.printf("%.2f",PriceCalculator.calculatePrice(reservation));

    }
}
