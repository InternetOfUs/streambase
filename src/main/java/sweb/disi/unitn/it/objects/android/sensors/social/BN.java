package sweb.disi.unitn.it.objects.android.sensors.social;

/**
 * Bluetooth normal event
 */
public class BN extends BluetoothEvent {

    public BN(){

    }
    public BN(String experimentId, String userId, String timestamp, String address, String bondstate, String name, float rssi) {
        super(experimentId, userId, timestamp, name, address, bondstate, rssi);
    }
}
