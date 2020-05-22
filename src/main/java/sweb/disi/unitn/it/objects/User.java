package sweb.disi.unitn.it.objects;


import sweb.disi.unitn.it.objects.subscription.Entity;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private String email;

    @NotNull
    private String salt;
    private String firebasetoken;
    private String role;
    private String project;
    private String channelID;

    public User(){

    }

    public User(String email, String salt, String firebatoken, String role, String project) {
        this.email = email;
        this.salt = salt;
        this.firebasetoken = firebatoken;
        this.role = role;
        this.project = project;

        if(null == this.role){
            this.role = Entity.USER_TYPE;
        }

    }

    public User(String channelID, String salt, String role, String project) {
        this.channelID = channelID;
        this.salt = salt;
        this.role = role;
        this.project = project;
    }

    public String getChannelID() { return channelID; }

    public void setChannelID(String channelID) { this.channelID = channelID; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getFirebasetoken() {
        return firebasetoken;
    }

    public void setFirebasetoken(String firebasetoken) {
        this.firebasetoken = firebasetoken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
