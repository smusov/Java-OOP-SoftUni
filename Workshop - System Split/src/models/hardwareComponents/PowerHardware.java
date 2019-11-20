package models.hardwareComponents;

public class PowerHardware extends HardwareComponent {

    public PowerHardware(String name, int capacity, int memory) {
        super(name, decreaseCapacity(capacity), increaseMemory(memory));
    }

    private static int increaseMemory(int memory) {
        return memory + (memory * 3) / 4;
    }

    private static int decreaseCapacity(int capacity) {
        return capacity - (capacity * 3) / 4;
    }
}
