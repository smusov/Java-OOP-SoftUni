package pizzaCalories;

public class Dough {
    private static final double CALORIES = 2.0;

    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {

        try {
            DoughModifiers.valueOf(flourType);
            this.flourType = flourType;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            DoughModifiers.valueOf(bakingTechnique);
            this.bakingTechnique = bakingTechnique;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        return (CALORIES*this.weight)
                *DoughModifiers.valueOf(this.bakingTechnique).getValue()
                *DoughModifiers.valueOf(flourType).getValue();
    }

}
