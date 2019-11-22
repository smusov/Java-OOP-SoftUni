package core.databases.interfaces;

import models.hardwareComponents.interfaces.Hardware;
import models.softwareComponents.interfaces.Software;

import java.util.Map;

public interface Database {
    void registerHardware(Hardware hardware);

    void registerSoftware(String hardwareName, Software software);

    void releaseSoftware(String hardwareName, String softwareName);

    Map<String, Hardware> getHardwares();

    int getDatabaseSize();
}
