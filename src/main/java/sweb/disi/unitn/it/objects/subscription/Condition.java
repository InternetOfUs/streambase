package sweb.disi.unitn.it.objects.subscription;

import java.util.List;

public class Condition {

    private List<String> properties;

    public Condition(){

    }

    public Condition(List<String> properties){
        this.properties = properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<String> getProperties() {
        return properties;
    }
}
