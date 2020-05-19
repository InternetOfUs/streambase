package sweb.disi.unitn.it.objects.android.sensors.virtual;

/**
 * phone call out event
 */
public class CO extends CallEvent {

	public CO(){

	}
	public CO(String experimentId, String userId, String timestamp, String phoneNumber, String contactName, String startTime, String endTime, long duration) {
		super(experimentId, userId, timestamp, startTime, endTime, duration, phoneNumber, contactName);
	}
}
