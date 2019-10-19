package wildFarm.animalsImpl;

import wildFarm.foods.Food;
import wildFarm.foods.Meat;
import wildFarm.animals.Felime;

public class Tiger extends Felime {

    private static final String INVALID_FOOD = "%ss are not eating that type of food!";

    public Tiger(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)){
            super.setFoodEaten(new Meat(0));
            throw new IllegalArgumentException(String.format(INVALID_FOOD,super.getType()));

        }
        super.setFoodEaten(food);
    }
}
