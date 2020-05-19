package sweb.disi.unitn.it.objects.batchData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class JsonAll {

    @NotNull
    public String experimentId;
    @NotEmpty
    public List<Object> result = new ArrayList<Object>();

    public JsonAll(){

    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}
