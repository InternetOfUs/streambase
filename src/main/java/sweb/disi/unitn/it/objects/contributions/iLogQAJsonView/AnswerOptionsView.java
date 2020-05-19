package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerOptionsView {

    /** Answer id */
    private int id;

    /** Answer's conditions */
    private List<ConditionView> c;

    /** Answer's Paragraph (text and language) */
    private List<P> p;

    /** Condition id */
    private long c_id;

    public AnswerOptionsView(){

    }

    public AnswerOptionsView(int id, List<ConditionView> c, List<P> p, long c_id) {
        this.id = id;
        this.c = c;
        this.p = p;
        this.c_id = c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public long getC_id() {
        return c_id;
    }

    public void setP(List<P> p) {
        this.p = p;
    }

    public void setC(List<ConditionView> c) {
        this.c = c;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<ConditionView> getC() {
        return c;
    }

    public List<P> getP() {
        return p;
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("id", this.id);
        objectToReturn.put("c", getCVJSONArray(c));
        objectToReturn.put("p", getPJSONArray(p));
        objectToReturn.put("c_id", this.c_id);

        return objectToReturn;
    }

    @Override
    public String toString(){
        return this.toJSONObject().toString();
    }


    private JSONArray getPJSONArray(List<P> objects) {

        if (null == objects) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();

        for (P obj : objects){
            objectToReturn.put(obj.toJSONObject());
        }

        return objectToReturn;
    }

    private JSONArray getCVJSONArray(List<ConditionView> objects) {

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