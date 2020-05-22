package sweb.disi.unitn.it.objects.android.sensors.social;

/**
 * Bluetooth low energy event
 */
public class BL extends BluetoothEvent {

    public BL(){

    }
    public BL(String experimentId, String userId, String timestamp, String address, String bondstate, String name, float rssi) {
        super(experimentId, userId, timestamp, name, address, bondstate, rssi);
    }
}
