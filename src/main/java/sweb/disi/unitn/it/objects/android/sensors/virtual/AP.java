package sweb.disi.unitn.it.objects.android.sensors.virtual;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * application event
 */
public class AP extends AbstractSensorEvent {

    private String applicationName;

    public AP(){

    }
    public AP(String experimentId, String userId, String timestamp, String applicationName) {
        super(timestamp, experimentId, userId);
        this.applicationName = applicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }
}
