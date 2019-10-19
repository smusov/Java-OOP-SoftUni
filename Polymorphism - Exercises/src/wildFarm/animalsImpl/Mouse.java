package wildFarm.animalsImpl;

import wildFarm.foods.Food;
import wildFarm.animals.Mammal;
import wildFarm.foods.Vegatable;

public class Mouse extends Mammal {

    private static final String INVALID_FOOD = "Mice are not eating that type of food!";

    public Mouse(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegatable)){
            super.setFoodEaten(new Vegatable(0));
            throw new IllegalArgumentException(INVALID_FOOD);
        }
        super.setFoodEaten(food);
    }
}
