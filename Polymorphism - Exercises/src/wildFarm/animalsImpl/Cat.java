package wildFarm.animalsImpl;

import wildFarm.foods.Food;
import wildFarm.animals.Felime;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String name, String type, Double weight, String livingRegion,String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food);
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]",
                super.getType(),
                super.getName(),
                this.breed,
                format.format(super.getWeight()),
                super.getLivingRegion(),
                super.getFoodEaten());
    }
}
