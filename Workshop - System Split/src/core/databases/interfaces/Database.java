package core.databases.interfaces;

import models.hardwareComponents.interfaces.Hardware;
import models.softwareComponents.interfaces.Software;

public interface Database {
    void registerHardware(Hardware hardware);

    void registerSoftware(String hardwareName, Software software);

    void releaseSoftware(String hardwareName, String softwareName);

    String getAnalyse();

    String getSystemSplit();
}
