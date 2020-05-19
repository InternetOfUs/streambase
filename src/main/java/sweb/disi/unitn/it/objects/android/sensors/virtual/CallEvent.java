package sweb.disi.unitn.it.objects.android.sensors.virtual;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

public class CallEvent extends AbstractSensorEvent {

	private String starttime;
	private String endtime;
	private long duration;
	private String phonenumber;
	private String contactname;

	public CallEvent(){

	}
	protected CallEvent(String experimentId, String userId, String timestamp, String starttime, String endtime, long duration, String phonenumber, String contactname) {
		super(timestamp, experimentId, userId);
		this.starttime = starttime;
		this.endtime = endtime;
		this.duration = duration;
		this.phonenumber = phonenumber;
		this.contactname = contactname;
	}
	public String getStarttime() {
		return starttime;
	}

	public String getEndtime() {
		return endtime;
	}
	
	public long getDuration() {
		return duration;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public String getContactname() {
		return contactname;
	}
}
