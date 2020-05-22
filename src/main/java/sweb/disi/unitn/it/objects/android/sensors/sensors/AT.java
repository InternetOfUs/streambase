package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * Ambient temperature event
 *
 */
public class AT extends AbstractSensorEvent {

    private float value;

    public AT(){

    }
    public AT(String experimentId, String userId, String timestamp, float temperature) {
        super(timestamp, experimentId, userId);
        this.value = temperature;
    }
    
    public float getValue() {
        return value;
    }
}
