package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.json.JSONObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConditionView {

    /** Question id to which the answer or the question is conditioned */
    int q;

    /** Answer id to which the answer or the question is conditioned */
    int a;

    public ConditionView(){

    }
    public ConditionView(int q, int a){

        this.q = q;
        this.a = a;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getQ() {
        return q;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("q", q);
        objectToReturn.put("a", a);

        return objectToReturn;
    }

    @Override
    public String toString(){
        return this.toJSONObject().toString();
    }

}

