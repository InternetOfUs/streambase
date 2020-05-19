package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * Light event
 */
public class LI extends AbstractSensorEvent {

    /**
     * Ambient light level in SI lux units
     */
    private float value;

    public LI(){

    }
    public LI(String experimentId, String userId, String timestamp, float value) {
        super(timestamp, experimentId, userId);
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
