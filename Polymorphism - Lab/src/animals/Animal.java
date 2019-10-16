package animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public abstract String explainSelf();

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String getName() {
        return name;
    }

    protected String getFavouriteFood() {
        return favouriteFood;
    }
}
