package sweb.disi.unitn.it.objects.subscription;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subscription {

    private String id;

    private String description;

    @NotNull
    private Entity entity;

    private Notification notification;

    private Condition condition;

    public Subscription(String id, String description, Entity entity, Notification notification, Condition condition ){
        this.id = id;
        this.description = description;
        this.entity = entity;
        this.notification = notification;
        this.condition = condition;
    }

    public Subscription(){

    }

    public String getId(){ return this.id;}

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity (Entity entity) {
        this.entity = entity;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
