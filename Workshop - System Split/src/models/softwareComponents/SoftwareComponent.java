package models.softwareComponents;

import models.softwareComponents.interfaces.Software;

public abstract class SoftwareComponent implements Software {
    private String name;
    private int capacityConsumption;
    private int memoryConsumption;

    public SoftwareComponent(String name, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacityConsumption() {
        return this.capacityConsumption;
    }

    @Override
    public int getMemoryConsumption() {
        return this.memoryConsumption;
    }
}
