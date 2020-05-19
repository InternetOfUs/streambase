package sweb.disi.unitn.it.objects.android.sensors;

import java.text.DecimalFormat;

public class Point {

    double latitude = 0.0;
    double longitude = 0.0;
    double altitude =-1;

    public Point(){

    }
    public Point(double altitude, double latitude, double longitude) {
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    double roundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.####");
        return Double.valueOf(df2.format(val));
    }
}
