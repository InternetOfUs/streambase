package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionAnswerView {

    /** Question */
    private QuestionView q;

    /** Possible Answers */
    private List<AnswerOptionsView> a;

    public QuestionAnswerView(){

    }
    public QuestionAnswerView(QuestionView q, List<AnswerOptionsView> a){
        this.q = q;
        this.a = a;
    }

    public List<AnswerOptionsView> getA() {
        return a;
    }

    public QuestionView getQ() {
        return q;
    }

    public void setA(List<AnswerOptionsView> a) {
        this.a = a;
    }

    public void setQ(QuestionView q) {
        this.q = q;
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("q", getJSONObject(q));
        objectToReturn.put("a", getJSONArray(a));

        return objectToReturn;
    }

    @Override
    public String toString(){
        return this.toJSONObject().toString();
    }

    private JSONObject getJSONObject(QuestionView q){

        return ((null == q) ? null : q.toJSONObject());
    }

    private JSONArray getJSONArray(List<AnswerOptionsView> a) {

        if (null == a) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();
        for (AnswerOptionsView aov : a){
            objectToReturn.put(aov.toJSONObject());
        }

        return objectToReturn;
    }
}