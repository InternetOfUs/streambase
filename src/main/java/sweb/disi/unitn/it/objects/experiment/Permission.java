package sweb.disi.unitn.it.objects.experiment;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.json.JSONObject;

/** Permission to ask for to users*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission {

    /** Single sensor */
    private boolean singleSensor;

    /** Background */
    private String background;

    /** Permission name */
    private String permission;

    /** Weather the permission can be skipped */
    private boolean skip;

    /** Confirmation text */
    private MultiLanguageText confirmation;

    /** Permission title */
    private MultiLanguageText title;

    /** Message to show to the user */
    private MultiLanguageText message;

    /** Message Low */
    private MultiLanguageText messageLow;

    /** Message High */
    private MultiLanguageText messageHigh;

    /** Position in which to display the permission on the user's phone */
    private int order;

    public Permission(){

    }

    public MultiLanguageText getMessageHigh() {
        return messageHigh;
    }

    public void setMessageHigh(MultiLanguageText messageHigh) {
        this.messageHigh = messageHigh;
    }

    public MultiLanguageText getMessageLow() {
        return messageLow;
    }

    public void setMessageLow(MultiLanguageText messageLow) {
        this.messageLow = messageLow;
    }

    public boolean isSingleSensor() {
        return singleSensor;
    }

    public void setSingleSensor(boolean singleSensor) {
        this.singleSensor = singleSensor;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public MultiLanguageText getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(MultiLanguageText confirmation) {
        this.confirmation = confirmation;
    }

    public MultiLanguageText getTitle() {
        return title;
    }

    public void setTitle(MultiLanguageText title) {
        this.title = title;
    }

    public MultiLanguageText getMessage() {
        return message;
    }

    public void setMessage(MultiLanguageText message) {
        this.message = message;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {

        return this.toJSONObject().toString();
    }

    public JSONObject toJSONObject() {

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("singleSensor", this.singleSensor);
        objectToReturn.put("background", this.background);
        objectToReturn.put("permission", this.permission);
        objectToReturn.put("skip", this.skip);
        objectToReturn.put("confirmation", getJSONObject(this.confirmation));
        objectToReturn.put("title", getJSONObject(this.title));
        objectToReturn.put("message", getJSONObject(this.message));
        objectToReturn.put("messageLow", getJSONObject(this.messageLow));
        objectToReturn.put("messageHigh", getJSONObject(this.messageHigh));
        objectToReturn.put("order", this.order);

        return objectToReturn;
    }

    private JSONObject getJSONObject(MultiLanguageText o){

        if (null == o){
            return null;
        }

        return o.toJSONObject();
    }
}
