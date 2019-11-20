package factories;

import models.hardwareComponents.HeavyHardware;
import models.hardwareComponents.PowerHardware;
import models.hardwareComponents.interfaces.Hardware;

public class HardwareFactory {

    public static Hardware makePowerHardware(String name, int capacity, int memory) {


        return new PowerHardware(name, capacity, memory);
    }

    public static Hardware makeHeavyHardware(String name, int capacity, int memory) {

        return new HeavyHardware(name, capacity, memory);
    }
}
