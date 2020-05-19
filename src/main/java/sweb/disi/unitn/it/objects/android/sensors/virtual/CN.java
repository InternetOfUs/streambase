package sweb.disi.unitn.it.objects.android.sensors.virtual;


import sweb.disi.unitn.it.objects.android.sensors.AbstractSensorEvent;

/**
 * cellular network
 */
public class CN extends AbstractSensorEvent {

    private int dbm;
    private String cellId;
    private String type;

    public CN(){

    }
    public CN(String experimentId, String userId, String timestamp, int dbm, String cellId, String type) {
        super(timestamp, experimentId, userId);
        this.dbm = dbm;
        this.cellId = cellId;
        this.type = type;
    }

    public int getDbm() {
        return dbm;
    }

    public String getCellId() {
        return cellId;
    }

    public String getType() {
        return type;
    }
}