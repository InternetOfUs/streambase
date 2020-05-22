package sweb.disi.unitn.it.objects.android.sensors.sensors;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * The attribute "labels" contains a string encoded with Base64.
 * 
 * <p>
 * <b>Example</b>: W3siT25Gb290Ijo5MH0seyJXYWxraW5nIjo5MH0seyJSdW5uaW5nIjoxMH1d
 * <br>
 * The decoded value is:  [{"OnFoot":90},{"Walking":90},{"Running":10}]
 * It contains labels and accuracy.
 * 
 * <p>
 * <b>Note</b>
 * 
 * When this object is serialize to Json it contains the decoded value.
 * When this object is deserialize to the MV class, it contains the encoded value.
 */
public class MV extends AbstractSensorEvent {

    private String labels = null;

    public MV(){

    }
    public MV(String experimentId, String userId, String timestamp, String label) {
        super(timestamp, experimentId, userId);
        this.labels = label;
    }

    public String getLabels() {
        return labels;
    }
}

