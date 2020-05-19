package sweb.disi.unitn.it.objects.android.sensors.virtual;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * touch event
 */
public class TE extends AbstractSensorEvent {

	public TE(){

	}
	public TE(String experimentId, String userId, String timestamp) {
		super(timestamp, experimentId, userId);
	}

}
