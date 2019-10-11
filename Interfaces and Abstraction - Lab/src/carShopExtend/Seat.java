package carShopExtend;

public class Seat extends CarImpl  implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString()+System.lineSeparator()+String.format("%s sells for %f",getModel(),getPrice());
    }
}
