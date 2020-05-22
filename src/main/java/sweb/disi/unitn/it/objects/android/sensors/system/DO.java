package sweb.disi.unitn.it.objects.android.sensors.system;


import sweb.disi.unitn.it.objects.android.sensors.BooleanSensorEvent;

/**
 * Doze event
 */
public class DO extends BooleanSensorEvent {

    public DO(){

    }
    public DO(String experimentId, String userId, String timestamp, boolean status) {
        super(experimentId, userId, timestamp, status);
    }
}
