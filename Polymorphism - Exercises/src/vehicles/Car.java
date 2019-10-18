package vehicles;

public class Car extends Vehicles {

    private static final double CLIMATIC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + CLIMATIC_CONSUMPTION);
    }
}
