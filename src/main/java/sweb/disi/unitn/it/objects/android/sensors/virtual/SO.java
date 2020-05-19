package sweb.disi.unitn.it.objects.android.sensors.virtual;

/**
 * sms out event
 */
public class SO extends SmsEvent {

	public SO(){

	}

	public SO(String experimentId, String userId, String timestamp, String phonenumber, String contactname) {
		super(experimentId, userId, timestamp, phonenumber, contactname);
	}
	
}
