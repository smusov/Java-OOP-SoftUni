package facade;

public class Main {
    public static void main(String[] args) {
        Car car = new  CarBuilderFacade()
                .info()
                .withType("Audi")
                .withColor("Bronze")
                .withNumberOfDoors(5)
                .built()
                .inCity("Sofia")
                .atAddress("asd 1123")
                .build();

        System.out.println(car);
    }
}
