package vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] vehiclesData = read.readLine().split("\\s+");

        double carFuel = Double.parseDouble(vehiclesData[1]);
        double carConsumption = Double.parseDouble(vehiclesData[2]);

        Vehicles car = new Car(carFuel,carConsumption);

        vehiclesData = read.readLine().split("\\s+");

        double truckFuel = Double.parseDouble(vehiclesData[1]);
        double truckConsumption = Double.parseDouble(vehiclesData[2]);

        Vehicles truck = new Truck(truckFuel,truckConsumption);

        int n = Integer.parseInt(read.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = read.readLine().split("\\s+");

            double value = Double.parseDouble(data[2]);

            switch (data[0]){
                case "Drive":
                    if (data[1].equals("Car")){
                        System.out.println(car.drive(value));
                    }else {
                        System.out.println(truck.drive(value));
                    }
                    break;
                case "Refuel":
                    if (data[1].equals("Car")){
                        car.refuel(value);
                    }else {
                        truck.refuel(value);
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
