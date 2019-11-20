package core.databases.interfaces;

public interface DumpHardwareDatabase extends Database {

    void dumpHardware(String hardwareName);

    void restoreHardware(String hardwareName);

    void destroyHardware(String hardwareName);

    String getDumpAnalyse();
}
