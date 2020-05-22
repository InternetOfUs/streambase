package sweb.disi.unitn.it.objects.android.sensors.ambience;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

import java.util.List;

/**
 * wifinetworksevent
 */
public class WN extends AbstractSensorEvent {

    //day text, name text, timestamp timestamp, address text, capabilities list<text>, frequency int, rssi float

    public WN (){

    }
    private String name;
    private String address;
    private int frequency;
    private float rssi;
    private List<String> capabilities;

    public WN(String experimentId, String userId, String timestamp, String address, List<String> capabilities, int frequency, float rssi, String name) {
        super(timestamp, experimentId, userId);
        this.name = name;
        this.address = address;
        this.frequency = frequency;
        this.rssi = rssi;
        this.capabilities = capabilities;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getFrequency() {
        return frequency;
    }

    public float getRssi() {
        return rssi;
    }

    public List<String> getCapabilities() {
        return capabilities;
    }
}