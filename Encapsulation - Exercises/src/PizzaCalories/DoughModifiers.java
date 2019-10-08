package PizzaCalories;

public enum DoughModifiers {

    White(1.5),
    Wholegrain(1.0),
    Crispy(0.9),
    Chewy(1.1),
    Homemade(1.0);

    double value;

    DoughModifiers(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
