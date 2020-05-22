package sweb.disi.unitn.it.objects.experiment;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.json.JSONObject;

/**
 * Text translated into several languages
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiLanguageText {

    /** English  */
    private String en_US;

    /** Italian */
    private String it_IT;

    /** Spanish */
    private String es_ES;

    public MultiLanguageText(){

    }

    public String getEn_US() {
        return en_US;
    }

    public void setEn_US(String en_US) {
        this.en_US = en_US;
    }

    public String getIt_IT() {
        return it_IT;
    }

    public void setIt_IT(String it_IT) {
        this.it_IT = it_IT;
    }

    public String getEs_ES() {
        return es_ES;
    }

    public void setEs_ES(String es_ES) {
        this.es_ES = es_ES;
    }

    @Override
    public String toString() {

        return this.toJSONObject().toString();
    }

    public JSONObject toJSONObject() {

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("en_US", this.getEn_US());
        objectToReturn.put("es_ES", this.getEs_ES());
        objectToReturn.put("it_IT", this.getIt_IT());

        return objectToReturn;
    }
}
