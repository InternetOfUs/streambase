package sweb.disi.unitn.it.objects.android.sensors.virtual;

import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * screen event
 */
public class SC extends AbstractSensorEvent {

    private String status;

    public SC(){

    }
	public SC(String experimentId, String userId, String timestamp, String status) {
        super(timestamp, experimentId, userId);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
