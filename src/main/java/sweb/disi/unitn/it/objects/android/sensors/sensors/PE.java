package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * Pressure event
 */
public class PE extends AbstractSensorEvent {

    /**
     * Atmospheric pressure in hPa (millibar)
     */
    private float value;
    public PE(){

    }
    public PE(String experimentId, String userId, String timestamp, float value) {
        super(timestamp, experimentId, userId);
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
