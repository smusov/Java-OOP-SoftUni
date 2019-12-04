package facade;

public class CarInfoBuilder extends CarBuilderFacade {

    public CarInfoBuilder(Car car) {
        this.car = car;
    }

    public CarInfoBuilder withType(String type){
        car.setType(type);
        return this;
    }
    public CarInfoBuilder withColor(String color){
        car.setColor(color);
        return this;
    }
    public CarInfoBuilder withNumberOfDoors(int numberOfDoors){
        car.setNumberOfDoors(numberOfDoors);
        return this;
    }
}
