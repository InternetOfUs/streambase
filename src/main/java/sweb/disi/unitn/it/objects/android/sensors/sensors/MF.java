package sweb.disi.unitn.it.objects.android.sensors.sensors;

import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Magnetic field event
 */
public class MF extends ThreeDimensionSensorEvent {

    /**
     * the ambient magnetic field in the X axis in micro-Tesla (uT)
     * the ambient magnetic field in the Y axis in micro-Tesla (uT)
     * the ambient magnetic field in the Z axis in micro-Tesla (uT)
     */
    public MF(){

    }
    public MF(String experimentId, String userId, String timestamp, float x, float y, float z) {
        super(experimentId, userId, timestamp, x, y, z);
    }
}
