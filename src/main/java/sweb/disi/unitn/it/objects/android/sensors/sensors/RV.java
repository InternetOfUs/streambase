package sweb.disi.unitn.it.objects.android.sensors.sensors;

import sweb.disi.unitn.it.objects.android.sensors.ThreeDimensionSensorEvent;

/**
 * Rotation vector event
 */
public class RV extends ThreeDimensionSensorEvent {

    /**
     * Rotation vector component along the x axis (x * sin(θ/2)).
     * Rotation vector component along the y axis (x * sin(θ/2)).
     * Rotation vector component along the z axis (x * sin(θ/2)).
     */

    /**
     * Scalar component of the rotation vector ((cos(θ/2))
     */
    private float scalar;

    public RV(){

    }
    public RV(String experimentId, String userId, String timestamp, float x, float y, float z, float scalar) {
        super(experimentId, userId, timestamp, x, y, z);
        this.scalar = scalar;
    }

    public float getScalar() {
        return scalar;
    }
}
