package core.databases.interfaces;

import models.hardwareComponents.interfaces.Hardware;

import java.util.Map;

public interface DumpHardwareDatabase extends Database {

    void dumpHardware(String hardwareName);

    void restoreHardware(String hardwareName);

    void destroyHardware(String hardwareName);

    Map<String, Hardware> getDumpedHardware();

    int getDumpHardwaresSize();
}
