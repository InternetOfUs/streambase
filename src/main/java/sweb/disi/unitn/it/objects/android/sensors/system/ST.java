package sweb.disi.unitn.it.objects.android.sensors.system;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * statistics
 */
public class ST extends AbstractSensorEvent {

    private String salt;
    private String appVersion;
    private String osVersion;
    private String deviceModel;
    private String manufacturer;
    private long timeFromStart;
    private String eventType;
    private String eventPayload;

    public ST(){

    }
    public ST(String salt, String timestamp, String appVersion, String osVersion, String deviceModel, String manufacturer, long timeFromStart, String eventType, String eventPayload) {
        super(timestamp);
        this.salt = salt;
        this.appVersion = appVersion;
        this.osVersion = osVersion;
        this.deviceModel = deviceModel;
        this.manufacturer = manufacturer;
        this.timeFromStart = timeFromStart;
        this.eventType = eventType;
        this.eventPayload = eventPayload;
    }
    public String getSalt() {
        return salt;
    }
    
    public String getAppVersion() {
        return appVersion;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public long getTimeFromStart() {
        return timeFromStart;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventPayload() {
        return eventPayload;
    }
}
