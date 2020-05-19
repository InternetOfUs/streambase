package sweb.disi.unitn.it.objects.android.sensors.audio;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * AudioEvent
 */
public class AU extends AbstractSensorEvent {

    private String audio;

    public AU(){

    }
    public AU(String experimentId, String userId, String timestamp, String audioStream) {
        super(timestamp, experimentId, userId);
        this.audio = audioStream;
    }

    public String getAudio() {
        return audio;
    }
}
