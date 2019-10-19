package vehiclesExtension;

public class Car extends Vehicles {

    private static final double CLIMATIC_CONSUMPTION = 0.9;


    protected Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }
}
