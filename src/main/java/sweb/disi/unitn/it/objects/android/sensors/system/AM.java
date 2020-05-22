package sweb.disi.unitn.it.objects.android.sensors.system;

import sweb.disi.unitn.it.objects.android.sensors.BooleanSensorEvent;

/**
 * Airplane mode event
 */
public class AM extends BooleanSensorEvent {

    public AM(){

    }
    public AM(String experimentId, String userId, String timestamp, boolean active) {
        super(experimentId, userId, timestamp, active);
    }
}
