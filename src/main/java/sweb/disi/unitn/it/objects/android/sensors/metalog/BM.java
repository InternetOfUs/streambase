package sweb.disi.unitn.it.objects.android.sensors.metalog;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * BatteryMonitoringLog
 */
public class BM extends AbstractSensorEvent {

    /**
     * integer field containing the current battery level, from 0 to scale
     */
    private float level;

    /**
     * integer containing the maximum battery level
     */
    private float scale;

    public BM(){

    }
    public BM(String experimentId, String userId, String timestamp, float level, float scale) {
        super(timestamp, experimentId, userId);
        this.level = level;
        this.scale = scale;
    }

    public float getLevel() {
        return level;
    }

    public float getScale() {
        return scale;
    }
}
