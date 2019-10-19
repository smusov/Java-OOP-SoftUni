package wildFarm.animals;

import wildFarm.foods.Food;

public abstract class Animal {
    private String name;
    private String type;
    private Double weight;
    private Integer foodEaten;


    public Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);

    protected void setFoodEaten (Food food){
        this.foodEaten = food.getQuantity();
    }

    protected String getName() {
        return name;
    }

    protected String getType() {
        return type;
    }

    protected Double getWeight() {
        return weight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }
}
