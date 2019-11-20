package models.hardwareComponents.interfaces;

import models.softwareComponents.interfaces.Software;

public interface Hardware {
    String getName();

    void addSoftware(Software software);

    int getCapacity();

    int getMemory();

    int getUsedCapacity();

    int getUsedMemory();

    void removeSoftware(String softwareName);

    int getSoftwareCount();

    long getLightSoftwareComponentsCount();

    long getExpressSoftwareComponentsCount();
}
