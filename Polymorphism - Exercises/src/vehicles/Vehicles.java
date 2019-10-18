package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double consumption;

    protected Vehicles(double fuelQuantity, double consumption) {
        this.fuelQuantity = fuelQuantity;
        this.consumption = consumption;
    }

    public void refuel (double liters){
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


    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
