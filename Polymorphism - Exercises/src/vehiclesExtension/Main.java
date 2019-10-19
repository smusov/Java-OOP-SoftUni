package vehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String[] vehiclesData = read.readLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(vehiclesData[1]),Double.parseDouble(vehiclesData[2]),Double.parseDouble(vehiclesData[3]));

        vehiclesData = read.readLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(vehiclesData[1]),Double.parseDouble(vehiclesData[2]),Double.parseDouble(vehiclesData[3]));

        vehiclesData = read.readLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(vehiclesData[1]),Double.parseDouble(vehiclesData[2]),Double.parseDouble(vehiclesData[3]));

        int n = Integer.parseInt(read.readLine());

        for (int i = 0; i < n; i++) {
            String[] data = read.readLine().split("\\s+");

            double value = Double.parseDouble(data[2]);

            switch (data[0]){
                case "Drive":
                    if (data[1].equals("Car")){
                        System.out.println(car.drive(value));
                    }else if (data[1].equals("Truck")) {
                        System.out.println(truck.drive(value));
                    }else {
                        System.out.println(bus.drive(value));
                    }
                    break;
                case "Refuel":
                    try {

                        if (data[1].equals("Car")){
                            car.refuel(value);
                        }else if (data[1].equals("Truck")){
                            truck.refuel(value);
                        }else {
                            bus.refuel(value);
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    try {
                        System.out.println(bus.driveEmpty(value));

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
