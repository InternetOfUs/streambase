package sweb.disi.unitn.it.objects.android.sensors.system;


import sweb.disi.unitn.it.objects.android.sensors.BooleanSensorEvent;

/**
 * headset plug event
 */
public class HP extends BooleanSensorEvent {

    public HP(){

    }
    public HP(String experimentId, String userId, String timestamp, boolean plugged) {
        super(experimentId, userId, timestamp, plugged);
    }
}
