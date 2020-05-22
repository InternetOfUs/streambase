package sweb.disi.unitn.it.objects.android.sensors;

public class BooleanSensorEvent extends AbstractSensorEvent{

	private boolean status;

	public BooleanSensorEvent(){

	}
	protected BooleanSensorEvent(String experimentId, String userId, String timestamp, boolean status) {
		super(timestamp, experimentId, userId);
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	
}
