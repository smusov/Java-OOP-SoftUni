package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double consumption;
    private double tankCapacity;

    private final static String INVALID_FUEL= "Fuel must be a positive number";
    private final static String FUEL_OVER_TANK_CAPACITY = "Cannot fit fuel in tank";

    protected Vehicles(double fuelQuantity, double consumption,double tankCapacity) {

        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;

    }

    protected double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void refuel (double liters){
        if (liters+this.fuelQuantity>this.tankCapacity){
            throw new IllegalArgumentException(FUEL_OVER_TANK_CAPACITY);
        }else if (liters<=0){
            throw new IllegalArgumentException(INVALID_FUEL);
        }
        this.fuelQuantity+=liters;
    }

    public String drive(double km){
        DecimalFormat format = new DecimalFormat("#.##");

        if (this.consumption * km <= this.fuelQuantity) {

            this.fuelQuantity = this.fuelQuantity-(this.consumption * km);

            return String.format("%s travelled %s km",this.getClass().getSimpleName(),format.format(km));

        }
        return String.format("%s needs refueling",this.getClass().getSimpleName());
    }

//    private void setTankCapacity(double tankCapacity) {
//        if (tankCapacity<=0){
//            throw new IllegalArgumentException(INVALID_FUEL);
//        }
//        this.tankCapacity = tankCapacity;
//    }

    protected void setFuelQuantity(double fuelQuantity) {

        if (fuelQuantity<0){
            throw new IllegalArgumentException(String.format("%s needs refueling",this.getClass().getSimpleName()));
        }

        this.fuelQuantity = fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
