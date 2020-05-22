package sweb.disi.unitn.it.objects.subscription;

import java.util.List;

public class Notification {

    private String url;

    private List<String> properties;

    public Notification(){

    }

    public Notification(String url, List<String> properties){

        this.url = url;
        this.properties = properties;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }
}
