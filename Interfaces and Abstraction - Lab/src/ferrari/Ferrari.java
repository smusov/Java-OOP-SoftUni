package ferrari;

public class Ferrari implements Car {
    private String driverName;
    private static String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
        //return "Zadu6avam sA!"; -> by condition 75/100
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", MODEL, this.brakes(), this.gas(), this.driverName);
    }
}
