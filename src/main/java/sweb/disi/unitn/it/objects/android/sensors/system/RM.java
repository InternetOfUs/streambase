package sweb.disi.unitn.it.objects.android.sensors.system;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * ring mode event
 */
public class RM extends AbstractSensorEvent {

    private String status;

    public RM(){

    }
    public RM(String experimentId, String userId, String timestamp, String ringMode) {
        super(timestamp, experimentId, userId);
        this.status = ringMode;
    }

    public String getStatus() {
        return status;
    }
}
