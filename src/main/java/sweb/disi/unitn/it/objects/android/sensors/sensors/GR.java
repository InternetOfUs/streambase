package sweb.disi.unitn.it.objects.android.sensors.sensors;

import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Gravity event
 */
public class GR extends ThreeDimensionSensorEvent {
    /**
     * Force of gravity along the x axis, m/s2
     * Force of gravity along the y axis, m/s2
     * Force of gravity along the z axis, m/s2
     */

    public GR(){

    }
    public GR(String experimentId, String userId, String timestamp, int x, int y, int z) {
        super(experimentId, userId, timestamp, x, y, z);
    }
}
