package sweb.disi.unitn.it.objects.android.sensors.virtual;

import com.fasterxml.jackson.annotation.JsonProperty;
import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * notification event
 */
public class NE extends AbstractSensorEvent {

    private String status;
    private String id;
    private String notificationPackage;
    private boolean isClearable;
    private boolean isOngoing;

    public NE(){

    }
    public NE(String experimentId, String userId, String timestamp, String notificationStatus, String nodificationId, String notificationPackage, boolean notificationIsClearable, boolean notificationIsOngoing) {
        super(timestamp, experimentId, userId);
        this.status = notificationStatus;
        this.id = nodificationId;
        this.notificationPackage = notificationPackage;
        this.isClearable = notificationIsClearable;
        this.isOngoing = notificationIsOngoing;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("package")
    public String getNotificationPackage() {
        return notificationPackage;
    }

    public boolean isIsClearable() {
        return isClearable;
    }

    public boolean isIsOngoing() {
        return isOngoing;
    }
}
