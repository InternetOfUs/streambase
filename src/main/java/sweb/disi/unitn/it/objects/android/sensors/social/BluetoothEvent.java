package sweb.disi.unitn.it.objects.android.sensors.social;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

public class BluetoothEvent extends AbstractSensorEvent {


	private String name;
	private String address;
	private String bondstate;
	private float rssi;

	public BluetoothEvent(){

	}
	protected BluetoothEvent(String experimentId, String userId, String timestamp, String name,
                             String address, String bondstate, float rssi) {
		super(timestamp, experimentId, userId);
		this.name = name;
		this.address = address;
		this.bondstate = bondstate;
		this.rssi = rssi;
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getBondstate() {
		return bondstate;
	}

	public float getRssi() {
		return rssi;
	}	
}
