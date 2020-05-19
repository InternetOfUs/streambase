package sweb.disi.unitn.it.objects.experiment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.QuestionAnswerView;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;


/**
 * Experiment Object
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Experiment {

    /** Code */
    @NotNull
    private int code;

    /** Id */
    @NotNull
    private String id;

    /** Title */
    private MultiLanguageText title;

    /** Configuration */
    @NotNull
    private Configuration configuration;

    /** Descriptioin */
    private MultiLanguageText description;

    /** Logo Address */
    private String logo;

    /** Informed consent about private data use */
    private MultiLanguageText informedConsent;

    /** Questions to send to the users to profile them */
    private List<QuestionAnswerView> profile;

    /** Sensors to enable during the experiment */
    private List<SensorId> sensors;

    /** Permissions configuration */
    private List<Permission> permissions;


    public Experiment(){

    }

    public Experiment(int code, String id, MultiLanguageText title, Configuration configuration, MultiLanguageText description, String logo, MultiLanguageText informedconsent, List<Permission> permissions, List<QuestionAnswerView> profile, List<SensorId> sensors) {

        this.code = code;
        this.id = id;
        this.title = title;
        this.configuration = configuration;
        this.description = description;
        this.logo = logo;
        this.informedConsent = informedconsent;
        this.permissions = permissions;
        this.profile = profile;
        this.sensors = sensors;
    }

    public Experiment(String code, String id, String title, String configuration, String description, String logo, String informedConsent, String permissions, String profile, String sensors) {

        final Logger logger = LogManager.getLogger(Experiment.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        try {
            this.code = Integer.valueOf(code);
            this.id = id;
            this.title = objectMapper.readValue(title, MultiLanguageText.class);
            this.configuration = objectMapper.readValue(configuration, Configuration.class);
            this.description = objectMapper.readValue(description, MultiLanguageText.class);
            this.logo = logo;
            this.informedConsent = objectMapper.readValue(informedConsent, MultiLanguageText.class);
            this.permissions = serializePermissions(permissions, objectMapper);
            this.profile = serializeProfile(profile, objectMapper);
            this.sensors = serializeSensors(sensors, objectMapper);

        } catch (Exception e){
            logger.error ("Error creating Experiment object. Json conversion not successfull");
            logger.error(e.getMessage());
        }
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public MultiLanguageText getDescription() {
        return description;
    }

    public void setDescription(MultiLanguageText description) {
        this.description = description;
    }

    public MultiLanguageText getTitle() {
        return title;
    }

    public void setTitle(MultiLanguageText title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public MultiLanguageText getInformedConsent() {
        return informedConsent;
    }

    public void setInformedConsent(MultiLanguageText informedConsent) {
        this.informedConsent = informedConsent;
    }

    public List<QuestionAnswerView> getProfile() {
        return profile;
    }

    public void setProfile(List<QuestionAnswerView> profile) {
        this.profile = profile;
    }

    public List<SensorId> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorId> sensors) {
        this.sensors = sensors;
    }

    private List<Permission> serializePermissions (String permissions, ObjectMapper objectMapper) throws Exception{

        if (null == permissions){
            return null;
        }

        return Arrays.asList(objectMapper.readValue(permissions, Permission[].class));
    }
    private List<QuestionAnswerView> serializeProfile (String profile, ObjectMapper objectMapper) throws Exception{

        if (null == profile){
            return null;
        }

        return Arrays.asList(objectMapper.readValue(profile, QuestionAnswerView[].class));
    }

    private List<SensorId> serializeSensors (String sensors, ObjectMapper objectMapper) throws Exception{

        if (null == sensors){
            return null;
        }

        return Arrays.asList(objectMapper.readValue(sensors, SensorId[].class));
    }
    @Override
    public String toString() {

        return this.toJSONObject().toString();
    }

    public JSONObject toJSONObject() {

        JSONObject objectToReturn = new JSONObject();

        objectToReturn.put("code", this.getCode());
        objectToReturn.put("id", this.getId());
        objectToReturn.put("title", this.getTitle());
        objectToReturn.put("configuration", this.getConfiguration().toJSONObject());
        objectToReturn.put("description", this.getDescription().toJSONObject());
        objectToReturn.put("logo", this.getLogo());
        objectToReturn.put("informedConsent", this.getInformedConsent().toJSONObject());
        objectToReturn.put("permissions", getPermissionsJSONArray(permissions));
        objectToReturn.put("profile", getProfileJSONArray(profile));
        objectToReturn.put("sensors", getSensorsJSONArray(sensors));

        return objectToReturn;
    }

    private JSONArray getProfileJSONArray(List<QuestionAnswerView> objects) {

        if (null == objects) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();

        for ( QuestionAnswerView obj : objects){
            objectToReturn.put(obj.toJSONObject());
        }

        return objectToReturn;
    }

    private JSONArray getSensorsJSONArray(List<SensorId> objects) {

        if (null == objects) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();

        for ( SensorId obj : objects){
            objectToReturn.put(obj.toJSONObject());
        }

        return objectToReturn;
    }

    private JSONArray getPermissionsJSONArray(List<Permission> objects) {

        if (null == objects) {
            return null;
        }

        JSONArray objectToReturn = new JSONArray();

        for ( Permission obj : objects){
            objectToReturn.put(obj.toJSONObject());
        }

        return objectToReturn;
    }
}
