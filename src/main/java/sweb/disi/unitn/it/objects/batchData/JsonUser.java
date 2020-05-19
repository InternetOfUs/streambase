package sweb.disi.unitn.it.objects.batchData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_EMPTY)
public class JsonUser {

    public JsonUser(){

    }

    @NotNull
    private String id;

    @NotEmpty
    private String email;

    public List<Property> sensordata = new ArrayList<Property>();

    public String getId (){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getEmail (){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSensordata(List<Property> sensordata) {
        this.sensordata = sensordata;
    }

    public List<Property> getSensordata() {
        return sensordata;
    }
}

