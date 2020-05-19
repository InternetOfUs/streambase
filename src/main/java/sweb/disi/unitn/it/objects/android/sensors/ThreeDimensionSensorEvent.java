package sweb.disi.unitn.it.objects.android.sensors;


public class ThreeDimensionSensorEvent extends AbstractSensorEvent{

	private float x;
    private float y;
    private float z;

    public ThreeDimensionSensorEvent(){

    }
    public ThreeDimensionSensorEvent(String experimentId, String userId, String timestamp, float x, float y, float z) {
		super(timestamp, experimentId, userId);
		this.x = x;
		this.y = y;
		this.z = z;
	}
    
	public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

}
