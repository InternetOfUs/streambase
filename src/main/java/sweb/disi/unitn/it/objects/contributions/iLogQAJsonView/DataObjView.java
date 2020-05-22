package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataObjView {

    /** latitude */
    private double lat;

    /** longitude */
    @JsonProperty("long")
    private double longitude;

    public  DataObjView(){

    }

    public double getLat() {
        return lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
