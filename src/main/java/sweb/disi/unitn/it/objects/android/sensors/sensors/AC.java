package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Accelerometer event
 *
 */
public class AC extends ThreeDimensionSensorEvent {

    /**
     * Acceleration minus Gx on the x-axis
     * Acceleration minus Gy on the y-axis
     * Acceleration minus Gz on the z-axis
     */

    public AC (){

    }
    public AC(String experimentId, String userId, String timestamp, float x, float y, float z) {
        super(experimentId, userId, timestamp, x, y, z);
    }
}
