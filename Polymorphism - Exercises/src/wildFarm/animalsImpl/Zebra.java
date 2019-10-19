package wildFarm.animalsImpl;

import wildFarm.animals.Mammal;
import wildFarm.foods.Food;
import wildFarm.foods.Vegatable;

public class Zebra extends Mammal {

    private static final String INVALID_FOOD = "%ss are not eating that type of food!";

    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegatable)){
            super.setFoodEaten(new Vegatable(0));
            throw new IllegalArgumentException(String.format(INVALID_FOOD,super.getType()));
        }
        super.setFoodEaten(food);
    }
}
