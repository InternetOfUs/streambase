package sweb.disi.unitn.it.objects.android.sensors.ambience;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * WifiEvent
 *<br>
 *<br>
 * bssid=9c:1c:12:af:93:25 <br>
 * ssid=_Free Airport WiFi <br>
 * isconnected=false
 * 
 */
public class WF extends AbstractSensorEvent {

    private String bssid;
    private String ssid;
    private String isconnected;

    public WF(){

    }
    public WF(String experimentId, String userId, String timestamp, String bssid, String ssid, String isconnected) {
        super(timestamp, experimentId, userId);
        this.bssid = bssid;
        this.ssid = ssid;
        this.isconnected = isconnected;
    }

    public String getBssid() {
        return bssid;
    }

    public String getSsid() {
        return ssid;
    }

    public String getIsconnected() {
        return isconnected;
    }

}
