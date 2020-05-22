package sweb.disi.unitn.it.objects.android.sensors.sensors;

import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Gyroscope event
 */
public class GY extends ThreeDimensionSensorEvent {

    /**
     * Angular speed around the x-axis
     * Angular speed around the y-axis
     * Angular speed around the z-axis
     */
    public GY(){

    }
    public GY(String experimentId, String userId, String timestamp, int x, int y, int z) {
        super(experimentId, userId, timestamp, x, y, z);
    }
}
