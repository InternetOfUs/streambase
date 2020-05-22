package sweb.disi.unitn.it.objects.android.sensors.virtual;

/**
 * phone call in event
 */
public class CI extends CallEvent {

	private String status;

	public CI(){

	}
	public CI(String experimentId, String userId, String timestamp, String phoneNumber, String contactName, String status,
              String startTime, String endTime, long duration) {
		super(experimentId, userId, timestamp, startTime, endTime, duration, phoneNumber, contactName);
		this.status=status;
	}

	public String getStatus() {
		return status;
	}
}
