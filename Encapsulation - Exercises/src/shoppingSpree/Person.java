package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {

        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {

        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {

        if (checkMoney(product.getCost())) {

            this.products.add(product);
            this.money -= product.getCost();

        } else {

            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));

        }
    }

    private boolean checkMoney(double cost) {
        return this.money - cost >= 0;
    }
}
