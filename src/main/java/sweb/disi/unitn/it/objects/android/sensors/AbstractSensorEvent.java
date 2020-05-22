package sweb.disi.unitn.it.objects.android.sensors;


public abstract class AbstractSensorEvent {

    /**
     * the timestamp of the event
     */
    private String experimentId;
    private String userId;
    private String timestamp;
	private String day;

    protected AbstractSensorEvent() {
    	
    }
    
    protected AbstractSensorEvent(String timestamp) {
        this.timestamp = timestamp;
        this.day = formatDay(timestamp);
    }

    protected AbstractSensorEvent(String timestamp, String experimentId, String userId) {
        this.experimentId = experimentId;
        this.userId = userId;
        this.timestamp = timestamp;
        this.day = formatDay(timestamp);
    }

    public String getExperimentId() {
        return this.experimentId;
    }
    public String getTimestamp() {
        return this.timestamp;
    }


    public String getUserId() {return this.userId; }

	public String getDay() {
		return day;
	}
	
	private static String formatDay(String timestamp) {
        return timestamp.substring(0, 8);
    }

}
