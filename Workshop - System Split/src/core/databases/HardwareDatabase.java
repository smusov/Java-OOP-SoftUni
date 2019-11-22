package core.databases;

import core.databases.interfaces.Database;
import models.hardwareComponents.interfaces.Hardware;
import models.softwareComponents.interfaces.Software;

import java.util.Collections;
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
    public Map<String, Hardware> getHardwares() {
        return Collections.unmodifiableMap(this.hardware);
    }
    @Override
    public int getDatabaseSize(){
        return this.hardware.size();
    }
}
