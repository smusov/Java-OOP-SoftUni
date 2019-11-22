package core.databases;

import core.databases.interfaces.DumpHardwareDatabase;
import models.hardwareComponents.interfaces.Hardware;

import java.util.Collections;
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
    public int getDumpHardwaresSize() {
        return this.dumpedHardware.size();
    }

    @Override
    public Map<String, Hardware> getDumpedHardware(){
        return Collections.unmodifiableMap(this.dumpedHardware);
    }
}
