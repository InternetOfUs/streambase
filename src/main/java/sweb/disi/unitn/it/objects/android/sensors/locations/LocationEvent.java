package sweb.disi.unitn.it.objects.android.sensors.locations;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;
import sweb.disi.unitn.it.objects.android.sensors.Point;

public class LocationEvent extends AbstractSensorEvent {

    /** Location Point */
    private Point point;
    private float accuracy;
    private String lucene = null;

    public LocationEvent(){
        super();
    }
	public LocationEvent(String experimentId, String userId, String timestamp, float accuracy, Point point, String lucene) {
        super(timestamp, experimentId, userId);
        this.point = point;
        this.accuracy = accuracy;
        this.lucene = lucene;
    }

    public Point getPoint() {
        return point;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public String getLucene() {
        return lucene;
    }
}
