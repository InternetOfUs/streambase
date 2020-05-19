package sweb.disi.unitn.it.objects.android.sensors.virtual;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

public class SmsEvent extends AbstractSensorEvent {

	private String phonenumber;
	private String contactname;

	public SmsEvent(){

	}
	protected SmsEvent(String experimentId, String userId, String timestamp, String phonenumber, String contactname) {
		super(timestamp, experimentId, userId);
		this.phonenumber = phonenumber;
		this.contactname = contactname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getContactname() {
		return contactname;
	}

}
