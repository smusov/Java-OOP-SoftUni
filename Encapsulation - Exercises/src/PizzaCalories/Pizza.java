package PizzaCalories;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private Dough dough;
    private ArrayList<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public String getName() {
        return name;
    }

    public double getOverallCalories() {
        return this.dough.calculateCalories() + this.toppings.stream().mapToDouble(Topping::calculateCalories).sum();
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {

        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() < this.numberOfToppings) {
            this.toppings.add(topping);
        }
    }
}
