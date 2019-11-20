package models.softwareComponents;

public class LightSoftware extends SoftwareComponent {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, setCapacityConsumption(capacityConsumption), setMemoryConsumption(memoryConsumption));
    }

    private static int setMemoryConsumption(int memoryConsumption) {
        return memoryConsumption - (memoryConsumption / 2);
    }

    private static int setCapacityConsumption(int capacityConsumption) {
        return capacityConsumption + (capacityConsumption / 2);
    }
}
