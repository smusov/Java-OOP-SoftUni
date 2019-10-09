package pizzaCalories;

public class Topping {
    private static final double CALORIES = 2.0;

    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        try {
            ToppingsModifiers.valueOf(toppingType);
            this.toppingType = toppingType;
        }catch (Exception e){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.",toppingType));
        }

    }

    private void setWeight(double weight) {

        if (weight<1||weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].",this.toppingType));
        }

        this.weight = weight;
    }
    public double calculateCalories (){
        return (this.weight* CALORIES)*ToppingsModifiers.valueOf(this.toppingType).getValue();
    }
}
