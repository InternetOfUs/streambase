package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class QuestionView {

    /** Question's id */
    private int id;

    /** Question's condition upon which it should be shown */
    private List<ConditionView> c;

    /** Question type*/
    private String t;

    /** Answer type */
    private String at;

    /** Question's Paragraph */
    private List<P> p;


    public QuestionView() {

    };

    public QuestionView(int id, List<ConditionView> c, String t, String at, List<P> p) {
        this.id = id;
        this.c = c;
        this.t = t;
        this.at = at;
        this.p = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ConditionView> getC() {
        return c;
    }

    public void setC(List<ConditionView> c) {

        this.c = c;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public List<P> getP() {
        return p;
    }

    public void setP(List<P> p) {
        this.p = p;
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("id", this.id);
        objectToReturn.put("c", getCVJSONArray(c));
        objectToReturn.put("t", this.t);
        objectToReturn.put("at", this.at);
        objectToReturn.put("p", getPJSONArray(p));

        return objectToReturn;
    }

    @Override
    public String toString(){
        return this.toJSONObject().toString();
    }

    private <T> JSONArray getPJSONArray(List<P> objects) {

        if (null == objects) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();

        for (P obj : objects){
            objectToReturn.put(obj.toJSONObject());
        }

        return objectToReturn;
    }

    private <T> JSONArray getCVJSONArray(List<ConditionView> objects) {

        if (null == objects) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();

        for (ConditionView obj : objects){
            objectToReturn.put(obj.toJSONObject());
        }

        return objectToReturn;
    }
}
