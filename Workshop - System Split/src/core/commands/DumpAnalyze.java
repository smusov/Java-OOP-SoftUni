package core.commands;

import models.hardwareComponents.interfaces.Hardware;

import java.util.List;

public class DumpAnalyze extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        return this.getDumpAnalyse();
    }

    private String getDumpAnalyse() {

        StringBuilder sb = new StringBuilder();

        sb.append("Dump Analysis").append(System.lineSeparator());
        sb.append("Power Hardware Components: ").append(getHardwareCount("PowerHardware")).append(System.lineSeparator());
        sb.append("Heavy Hardware Components: ").append(getHardwareCount("HeavyHardware")).append(System.lineSeparator());
        sb.append("Express Software Components: ").append(getExpressSoftwareCount()).append(System.lineSeparator());
        sb.append("Light Software Components: ").append(getLightSoftwareCount()).append(System.lineSeparator());
        sb.append("Total Dumped Memory: ").append(getTotalDumpedMemory()).append(System.lineSeparator());
        sb.append("Total Dumped Capacity: ").append(getTotalDumpedCapacity()).append(System.lineSeparator());

        return sb.toString();
    }

    private long getTotalDumpedCapacity() {
        return this.database.getDumpedHardware().values()
                .stream()
                .mapToInt(Hardware::getUsedCapacity)
                .sum();
    }

    private long getTotalDumpedMemory() {
        return this.database.getDumpedHardware().values()
                .stream()
                .mapToInt(Hardware::getUsedMemory)
                .sum();
    }

    private long getHardwareCount(String hardwareName) {
        return this.database.getDumpedHardware().values()
                .stream()
                .filter(e -> e.getClass().getSimpleName().equals(hardwareName))
                .count();
    }

    private long getExpressSoftwareCount() {
        return this.database.getDumpedHardware().values()
                .stream()
                .mapToLong(Hardware::getExpressSoftwareComponentsCount)
                .sum();
    }

    private long getLightSoftwareCount() {
        return database.getDumpedHardware().values()
                .stream()
                .mapToLong(Hardware::getLightSoftwareComponentsCount)
                .sum();
    }
}
