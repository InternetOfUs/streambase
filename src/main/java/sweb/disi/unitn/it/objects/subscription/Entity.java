package sweb.disi.unitn.it.objects.subscription;

public class Entity {

    private String id;
    private String type;

    public static final String USER_TYPE = "user";
    public static final String EXPERIMENT_TYPE = "experiment";
    public static final String APP_TYPE = "app";


    public Entity(){

    }

    public Entity(String id, String type){

        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
