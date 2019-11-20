package core.databases;

import core.databases.interfaces.DumpHardwareDatabase;
import models.hardwareComponents.interfaces.Hardware;

import java.util.LinkedHashMap;
import java.util.Map;

public class DumpHardwareDatabaseImpl extends HardwareDatabase implements DumpHardwareDatabase {

    private Map<String, Hardware> dumpedHardware;

    public DumpHardwareDatabaseImpl() {
        this.dumpedHardware = new LinkedHashMap<>();
    }

    @Override
    public void dumpHardware(String hardwareName) {

        if (super.containsHardware(hardwareName)) {
            this.dumpedHardware.put(hardwareName, super.removeHardware(hardwareName));
        }

    }

    @Override
    public void restoreHardware(String hardwareName) {
        if (this.dumpedHardware.containsKey(hardwareName)) {
            super.registerHardware(this.dumpedHardware.remove(hardwareName));
        }
    }

    @Override
    public void destroyHardware(String hardwareName) {
        this.dumpedHardware.remove(hardwareName);
    }

    @Override
    public String getDumpAnalyse() {

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
        return this.dumpedHardware.values()
                .stream()
                .mapToInt(Hardware::getUsedCapacity)
                .sum();
    }

    private long getTotalDumpedMemory() {
        return this.dumpedHardware.values()
                .stream()
                .mapToInt(Hardware::getUsedMemory)
                .sum();
    }

    private long getHardwareCount(String hardwareName) {
        return this.dumpedHardware.values()
                .stream()
                .filter(e -> e.getClass().getSimpleName().equals(hardwareName))
                .count();
    }

    private long getExpressSoftwareCount() {
        return this.dumpedHardware.values()
                .stream()
                .mapToLong(Hardware::getExpressSoftwareComponentsCount)
                .sum();
    }

    private long getLightSoftwareCount() {
        return this.dumpedHardware.values()
                .stream()
                .mapToLong(Hardware::getLightSoftwareComponentsCount)
                .sum();
    }
}
