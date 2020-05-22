package sweb.disi.unitn.it.objects.experiment;


import org.json.JSONObject;

/**
 * Sensor id
 */
public class SensorId {

    /**
     * Sensor's id as defined by android specification or as defined in iLog
     */
    private int id;

    public SensorId(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){

        return this.toJSONObject().toString();
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("id", this.id);

        return objectToReturn;
    }
}
