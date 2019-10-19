package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicles {

    private static final double CONSUMPTION_WITH_PEOPLE = 1.4;

    public Bus(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + CONSUMPTION_WITH_PEOPLE, tankCapacity);
    }

    public String driveEmpty(double km) {
        DecimalFormat format = new DecimalFormat("#.##");

        double emptyConsumption = super.getConsumption() - CONSUMPTION_WITH_PEOPLE;

        if (emptyConsumption* km <= super.getFuelQuantity()) {

            super.setFuelQuantity(super.getFuelQuantity() - (emptyConsumption * km));

            return String.format("%s travelled %s km", this.getClass().getSimpleName(), format.format(km));

        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

}
