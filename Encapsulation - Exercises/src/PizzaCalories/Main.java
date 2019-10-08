package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));

        String[] inputPizza = read.readLine().split("\\s+");

        Pizza pizza = new Pizza(inputPizza[1],Integer.parseInt(inputPizza[2]));

        String[] doughInput = read.readLine().split("\\s+");

        Dough dough = new Dough(doughInput[1],doughInput[2],Double.parseDouble(doughInput[3]));

        pizza.setDough(dough);

        String input;

        while(!"END".equals(input=read.readLine())){

            String[] topping = input.split("\\s+");

            pizza.addTopping(new Topping(topping[1],Double.parseDouble(topping[2])));

        }
        System.out.println(pizza.getOverallCalories());
    }
}