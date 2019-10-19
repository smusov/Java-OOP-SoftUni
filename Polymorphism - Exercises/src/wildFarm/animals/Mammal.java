package wildFarm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }


    @Override
    public String toString() {

        DecimalFormat format = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]",
                super.getType(),
                super.getName(),
                format.format(super.getWeight()),
                this.livingRegion,
                super.getFoodEaten());
    }

    protected String getLivingRegion() {
        return livingRegion;
    }
}
