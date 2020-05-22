package sweb.disi.unitn.it.objects.android.sensors.system;


import sweb.disi.unitn.it.objects.android.sensors.BooleanSensorEvent;

/**
 * music event
 */
public class MU extends BooleanSensorEvent {

    public MU(){

    }
    public MU(String experimentId, String userId, String timestamp, boolean playing) {
        super(experimentId, userId, timestamp, playing);
    }
}
