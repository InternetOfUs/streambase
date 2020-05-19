package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Linear acceleration event
 */
public class LA extends ThreeDimensionSensorEvent {

    /**
     * Acceleration force along the x axis (excluding gravity), m/s2
     * Acceleration force along the y axis (excluding gravity), m/s2
     * Acceleration force along the z axis (excluding gravity), m/s2
     */
    public LA(){

    }
    public LA(String experimentId, String userId, String timestamp, int x, int y, int z) {
        super(experimentId, userId, timestamp, x, y, z);
    }
   
}
