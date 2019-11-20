package models.hardwareComponents;

import models.hardwareComponents.interfaces.Hardware;
import models.softwareComponents.interfaces.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class HardwareComponent implements Hardware {
    private String name;
    private int capacity;
    private int memory;
    private int usedCapacity;
    private int usedMemory;
    private Map<String, Software> softwareComponents;

    HardwareComponent(String name, int capacity, int memory) {
        this.name = name;
        this.capacity = capacity;
        this.memory = memory;
        this.softwareComponents = new LinkedHashMap<>();
    }

    @Override
    public void addSoftware(Software software) {
        if (this.usedCapacity + software.getCapacityConsumption() <= this.capacity
                && this.usedMemory + software.getMemoryConsumption() <= this.memory) {

            this.softwareComponents.put(software.getName(), software);

            this.setUsedCapacity(this.usedCapacity + software.getCapacityConsumption());
            this.setUsedMemory(this.usedMemory + software.getMemoryConsumption());
        }
    }

    @Override
    public void removeSoftware(String softwareName) {

        if (this.softwareComponents.containsKey(softwareName)) {

            Software software = this.softwareComponents.get(softwareName);

            this.usedCapacity -= software.getCapacityConsumption();
            this.usedMemory -= software.getMemoryConsumption();
            this.softwareComponents.remove(softwareName);
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getMemory() {
        return memory;
    }

    @Override
    public int getUsedCapacity() {
        return usedCapacity;
    }

    @Override
    public int getUsedMemory() {
        return usedMemory;
    }

    @Override
    public int getSoftwareCount() {
        return this.softwareComponents.size();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        String size = this.softwareComponents.size() > 0 ?
                this.softwareComponents.keySet().toString().replaceAll("[\\[\\]]", "")
                :
                "None";

        sb.append("Hardware Component - ").append(this.name).append(System.lineSeparator());
        sb.append("Express Software Components - ").append(getExpressSoftwareComponentsCount()).append(System.lineSeparator());
        sb.append("Light Software Components - ").append(getLightSoftwareComponentsCount()).append(System.lineSeparator());
        sb.append(String.format("Memory Usage: %d / %d", this.getUsedMemory(), this.getMemory())).append(System.lineSeparator());
        sb.append(String.format("Capacity Usage: %d / %d", this.getUsedCapacity(), this.getCapacity())).append(System.lineSeparator());
        sb.append("Type: ").append(this.getClass().getSimpleName().replace("Hardware", "")).append(System.lineSeparator());
        sb.append("Software Components: ").append(size).append(System.lineSeparator());

        return sb.toString();
    }

    @Override
    public long getLightSoftwareComponentsCount() {
        return this.softwareComponents.values().stream().filter(e -> e.getClass().getSimpleName().equals("LightSoftware")).count();
    }

    @Override
    public long getExpressSoftwareComponentsCount() {
        return this.softwareComponents.values().stream().filter(e -> e.getClass().getSimpleName().equals("ExpressSoftware")).count();
    }

    private void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    private void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }
}
