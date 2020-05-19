package sweb.disi.unitn.it.objects.android.sensors.virtual;

/**
 * sms in event
 */
public class SI extends SmsEvent {

	public SI(){

	}
	public SI(String experimentId, String userId, String timestamp, String phonenumber, String contactname) {
		super(experimentId, userId, timestamp, phonenumber, contactname);
	}

}
