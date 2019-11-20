package core.databases;

import core.databases.interfaces.Database;
import models.hardwareComponents.interfaces.Hardware;
import models.softwareComponents.interfaces.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class HardwareDatabase implements Database {

    private Map<String, Hardware> hardware;

    public HardwareDatabase() {
        this.hardware = new LinkedHashMap<>();
    }

    @Override
    public void registerHardware(Hardware hardware) {
        this.hardware.put(hardware.getName(),hardware);
    }

    @Override
    public void registerSoftware(String hardwareName,Software software) {
        if (this.hardware.containsKey(hardwareName)){
            this.hardware.get(hardwareName).addSoftware(software);
        }
    }

    @Override
    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardware.containsKey(hardwareName)){
            this.hardware.get(hardwareName).removeSoftware(softwareName);
        }
    }

    Hardware removeHardware(String hardwareName){
        return this.hardware.remove(hardwareName);
    }

    boolean containsHardware(String hardwareName){
        return this.hardware.containsKey(hardwareName);
    }

    @Override
    public String getSystemSplit(){
        StringBuilder sb = new StringBuilder();
        this.hardware.values().forEach(e->sb.append(e.toString()));
        return sb.toString();
    }

    @Override
    public String getAnalyse(){

        StringBuilder sb = new StringBuilder();

        sb.append("System Analysis").append(System.lineSeparator());
        sb.append(String.format("Hardware Components: %d", getDatabaseSize())).append(System.lineSeparator());
        sb.append("Software Components: ").append(getSoftwareCount()).append(System.lineSeparator());
        sb.append(String.format("Total Operational Memory: %d / %d", getTotalUsedMemory(), getTotalMaxMemory())).append(System.lineSeparator());
        sb.append(String.format("Total Capacity Taken: %d / %d", getTotalCapacityTaken(), getTotalMaxCapacity()));

        return sb.toString();
    }


    private int getDatabaseSize(){
        return this.hardware.size();
    }



    private int getSoftwareCount(){
        return this.hardware.values()
                .stream()
                .mapToInt(Hardware::getSoftwareCount)
                .sum();
    }

    private int getTotalUsedMemory() {
        return this.hardware.values()
                .stream()
                .mapToInt(Hardware::getUsedMemory)
                .sum();
    }


    private int getTotalMaxMemory() {
        return hardware.values()
                .stream()
                .mapToInt(Hardware::getMemory)
                .sum();
    }


    private int getTotalCapacityTaken() {
        return this.hardware.values()
                .stream()
                .mapToInt(Hardware::getUsedCapacity)
                .sum();
    }


    private int getTotalMaxCapacity() {
        return this.hardware.values()
                .stream()
                .mapToInt(Hardware::getCapacity)
                .sum();
    }
}
