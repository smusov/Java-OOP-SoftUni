package models.softwareComponents;

public class ExpressSoftware extends SoftwareComponent {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, setMemoryConsumption(memoryConsumption));
    }

    private static int setMemoryConsumption(int memoryConsumption) {
        return memoryConsumption*2;
    }
}
