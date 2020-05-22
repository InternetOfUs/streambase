package sweb.disi.unitn.it.objects.android.sensors.metalog;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * SensorMonitoringLog
 * 
 * contains information about which sensors were started and stopped
 */
public class SM extends AbstractSensorEvent {

    /**
     * the ID of the sensor whose logging started or stopped
     */
    private String sensorId;

    /**
     * indicates if the logging was started (when TRUE) or stopped (when FALSE)
     */
    private String isLogging;

    public SM(){

    }
    public SM(String experimentId, String userId, String timestamp, String sensorId, String isLogging) {
        super(timestamp, experimentId, userId);
        this.sensorId = sensorId;
        this.isLogging = isLogging;
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getIsLogging() {
        return isLogging;
    }
}
