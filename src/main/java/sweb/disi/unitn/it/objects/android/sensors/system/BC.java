package sweb.disi.unitn.it.objects.android.sensors.system;


import sweb.disi.unitn.it.objects.android.sensors.BooleanSensorEvent;

/**
 * Battery charge event
 */
public class BC extends BooleanSensorEvent {

    private String source;

    public BC(){

    }
    public BC(String experimentId, String userId, String timestamp, boolean status, String source) {
        super(experimentId, userId, timestamp, status);
        this.source = source;
    }

    public String getSource() {
        return source;
    }
}
