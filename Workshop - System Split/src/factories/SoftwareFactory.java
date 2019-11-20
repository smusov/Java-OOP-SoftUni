package factories;

import models.softwareComponents.ExpressSoftware;
import models.softwareComponents.LightSoftware;
import models.softwareComponents.interfaces.Software;

public class SoftwareFactory {


    public static Software makeLightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        return new LightSoftware(name, capacityConsumption, memoryConsumption);
    }

    public static Software makeExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        return new ExpressSoftware(name, capacityConsumption, memoryConsumption);
    }
}
