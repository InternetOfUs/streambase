package sweb.disi.unitn.it.objects.android.sensors.locations;


import sweb.disi.unitn.it.objects.android.sensors.Point;

/**
 * Network location
 */
public class NL extends LocationEvent {

	public NL(){

	}
	public NL(String experimentId, String userId, String timestamp, float accuracy, Point point, String lucene) {
		super(experimentId, userId, timestamp, accuracy, point, lucene);
	}

}
