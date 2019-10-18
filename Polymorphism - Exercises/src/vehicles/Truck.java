package vehicles;

public class Truck extends Vehicles {

    private static final double CLIMATIC_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption+CLIMATIC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters*0.95);
    }
}
