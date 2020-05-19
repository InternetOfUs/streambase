package sweb.disi.unitn.it.objects.batchData;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class JsonUsers {

    @NotNull
    private String experimentId;
    @NotEmpty
    public List<JsonUser> users = new ArrayList<JsonUser>();

    public JsonUsers(){

    }


    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public List<JsonUser> getUsers() {
        return users;
    }

    public void setUsers(List<JsonUser> users) {
        this.users = users;
    }
}
