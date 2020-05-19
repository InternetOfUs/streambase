package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * Relative humidity event
 */
public class RH extends AbstractSensorEvent {

    /**
     * Relative ambient air humidity in percent
     */
    private float value;

    public RH(){

    }
    public RH(String experimentId, String userId, String timestamp, float value) {
        super(timestamp, experimentId, userId);
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
