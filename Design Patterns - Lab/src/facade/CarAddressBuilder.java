package facade;

public class CarAddressBuilder extends CarBuilderFacade{

    public CarAddressBuilder(Car car) {
        this.car = car;
    }

    public CarAddressBuilder inCity (String city){
        this.car.setCity(city);
        return this;
    }

    public CarAddressBuilder atAddress (String address){
        this.car.setAddress(address);
        return this;
    }
}
