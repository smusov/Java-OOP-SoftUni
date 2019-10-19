package wildFarm;

import wildFarm.animalsImpl.Cat;
import wildFarm.animalsImpl.Mouse;
import wildFarm.animalsImpl.Tiger;
import wildFarm.animalsImpl.Zebra;
import wildFarm.animals.Animal;
import wildFarm.foods.Food;
import wildFarm.foods.Meat;
import wildFarm.foods.Vegatable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String input;

        while (!"End".equals(input = read.readLine())) {

            String[] animalData = input.split("\\s+");
            Animal animal = getAnimal(animalData);

            String[] foodData = read.readLine().split("\\s+");
            Food food = getFood(foodData);

            animal.makeSound();

            try {
                animal.eat(food);
            }catch (IllegalArgumentException invalidFood){
                System.out.println(invalidFood.getMessage());
            }

            animals.add(animal);

        }
        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodData) {
        Food food;

        if (foodData[0].equals("Vegetable"))
            food = new Vegatable(Integer.parseInt(foodData[1]));
        else {
            food = new Meat(Integer.parseInt(foodData[1]));
        }
        return food;
    }

    private static Animal getAnimal(String[] animalData) {
        Animal animal = null;

        String type = animalData[0];
        String name = animalData[1];
        Double weight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];

        String breed = animalData.length == 5 ? animalData[4] : null;

        switch (type) {
            case "Cat":
                animal = new Cat(name, type, weight, livingRegion, breed);
                break;
            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, type, weight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(name, type, weight, livingRegion);
                break;
        }

        return animal;
    }
}
