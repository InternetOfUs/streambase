package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * Proximity event
 */
public class PO extends AbstractSensorEvent {

    /**
     * Proximity sensor distance measured in centimeters
     *
     * Note: Some proximity sensors only support a binary near or far measurement. In this case,
     * the sensor should report its maximum range value in the far state and a lesser value in the near state.
     */
    private float value;

    public PO(){

    }
    public PO(String experimentId, String userId, String timestamp, float value) {
        super(timestamp, experimentId, userId);
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
