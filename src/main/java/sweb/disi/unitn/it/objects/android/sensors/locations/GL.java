package sweb.disi.unitn.it.objects.android.sensors.locations;


import sweb.disi.unitn.it.objects.android.sensors.Point;

/**
 * GPS location
 */
public class GL extends LocationEvent {

	private float speed;
    private double bearing;

	public GL() {
		super();
	}
	public GL(String experimentId, String userId, String timestamp, float accuracy, double bearing, Point point, float speed,
			  String lucene) {
		super(experimentId, userId, timestamp, accuracy, point, lucene);
		this.speed = speed;
		this.bearing = bearing;
	}


	public float getSpeed() {
        return speed;
    }

    public double getBearing() {
        return bearing;
    }

}
