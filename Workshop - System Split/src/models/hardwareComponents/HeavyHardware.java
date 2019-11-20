package models.hardwareComponents;

public class HeavyHardware extends HardwareComponent {
    public HeavyHardware(String name, int capacity, int memory) {
        super(name, increaseCapacity(capacity), decreaseMemory(memory));
    }

    private static int decreaseMemory(int memory) {
        return memory - (memory * 25) / 100;
    }

    private static int increaseCapacity(int capacity) {
        return capacity * 2;
    }
}
