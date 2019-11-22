package core.commands;

import models.hardwareComponents.interfaces.Hardware;

import java.util.List;

public class Analyze extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        return getAnalyse();
    }

    private String getAnalyse(){

        StringBuilder sb = new StringBuilder();

        sb.append("System Analysis").append(System.lineSeparator());
        sb.append(String.format("Hardware Components: %d", super.database.getDatabaseSize())).append(System.lineSeparator());
        sb.append("Software Components: ").append(getSoftwareCount()).append(System.lineSeparator());
        sb.append(String.format("Total Operational Memory: %d / %d", getTotalUsedMemory(), getTotalMaxMemory())).append(System.lineSeparator());
        sb.append(String.format("Total Capacity Taken: %d / %d", getTotalCapacityTaken(), getTotalMaxCapacity()));

        return sb.toString();
    }

    private int getSoftwareCount(){
        return super.database.getHardwares().values()
                .stream()
                .mapToInt(Hardware::getSoftwareCount)
                .sum();
    }

    private int getTotalUsedMemory() {
        return super.database.getHardwares().values()
                .stream()
                .mapToInt(Hardware::getUsedMemory)
                .sum();
    }


    private int getTotalMaxMemory() {
        return super.database.getHardwares().values()
                .stream()
                .mapToInt(Hardware::getMemory)
                .sum();
    }


    private int getTotalCapacityTaken() {
        return super.database.getHardwares().values()
                .stream()
                .mapToInt(Hardware::getUsedCapacity)
                .sum();
    }


    private int getTotalMaxCapacity() {
        return super.database.getHardwares().values()
                .stream()
                .mapToInt(Hardware::getCapacity)
                .sum();
    }
}
