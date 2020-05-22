package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class P{

    /** Paragraph's language */
    private String l;

    /** Paragraph's text */
    private String t;
    
    @JsonCreator
    private P() {}
    
    public P(String l, String t) {
        this.l = l;
        this.t = t;
    }
    
    @JsonProperty("l")
    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    @JsonProperty("t")
    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("l", l);
        objectToReturn.put("t", t);

        return objectToReturn;
    }

    @Override
    public String toString(){
        return this.toJSONObject().toString();
    }
}