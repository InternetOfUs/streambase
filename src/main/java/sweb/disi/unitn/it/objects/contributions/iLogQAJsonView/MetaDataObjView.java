package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaDataObjView {

    /** latitude */
    private double lat;

    /** longitude */
    @JsonProperty("long")
    private double longitude;

    private String timestamp;

    public  MetaDataObjView(){

    }

    public double getLat() {
        return lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


}
