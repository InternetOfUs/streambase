package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Orientation event
 */
public class OR extends ThreeDimensionSensorEvent {

    /**
     * Azimuth (angle around the x-axis), Degrees
     * Azimuth (angle around the y-axis), Degrees
     * Azimuth (angle around the z-axis), Degrees
     */
    public OR(){

    }
    public OR(String experimentId, String userId, String timestamp, float x, float y, float z) {
        super(experimentId, userId, timestamp, x, y, z);
    }
}
