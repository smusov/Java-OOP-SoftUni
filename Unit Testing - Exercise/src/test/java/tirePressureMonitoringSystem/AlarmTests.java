package tirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

public class AlarmTests {

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void initialiseObjects(){
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(sensor);
    }

    @Test
    public void alarmShouldBeOnIfOutOfRange() {
        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(1.0);
        this.alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void alarmNotOnIfInRange() throws NoSuchFieldException, IllegalAccessException {

        Field sensorField = this.alarm.getClass().getDeclaredField("sensor");
        sensorField.setAccessible(true);
        sensorField.set(this.alarm,this.sensor);

        Assert.assertFalse(this.alarm.getAlarmOn());
    }

}
