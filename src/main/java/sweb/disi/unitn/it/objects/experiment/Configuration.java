package sweb.disi.unitn.it.objects.experiment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

/**
 * Experiment Configuration.
 *
 * The configuration is sent to the i-Log App after a user signs up to an experiment.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Configuration {

    /** Port separator */
    private String portSeparator;

    /** Separator */
    private String separator;

    /** Snooze notifications */
    private boolean snoozeNotifications;

    /** Break notifications */
    private boolean breakNotifications;

    /** Server url */
    private String serverBaseUrl;

    /** Logging restart interval */
    private int loggingRestartInterval;

    /** Bluetooth scan duration */
    private int bluetoothScanDuration;

    /** Bluetooth LE scan duration */
    private int bluetoothLEScanDuration;

    /** Sensor collection frequency */
    private int sensorCollectionFrequency;

    /** Bluetooth collection frequency */
    private int bluetoothCollectionFrequency;

    /** Bluetooth LE collection frequency */
    private int bluetoothLECollectionFrequency;

    /** Wifi collection frequency */
    private int wifiCollectionFrequency;

    /** Application collection frequency */
    private int applicationCollectionFrequency;

    /** Location collection frequency */
    private int locationCollectionFrequency;

    /** Cell info frequency */
    private int cellInfoFrequency;

    /** Update notification id */
    private int updateNotificationId;

    /** Main notification id */
    private int mainNotificationId;

    /** Questionnaire notification interval */
    private int questionnaireNotificationInterval;

    /** Minimum battery level */
    private int minimumBatteryLevel;

    /** Upload endpoint */
    private String endpointUpload;

    /** Upload Answers endpoint */
    private String endpointUploadAnswers;

    /** Get Available Challenges endpoint */
    private String endpointGetAvailableChallenges;

    /** Reception confirmation endpoint */
    private String endpointUploadReceptionConfirmation;

    /** Upload Challenges Synchronization info */
    private String endpointUploadChallengesSynchronizationInfo;

    /** Challenges Results Endpoint */
    private String endpointResultChallenges;

    /** Signup endpoint */
    private String endpointSignup;

    /** Login endpoint */
    private String endpointLogin;

    /** Upload profile endpoint */
    private String endpointUploadProfile;

    //TODO: change project to experiment
    /** Experiment endpoint */
    private String endpointProjects;

    /** Get Available Challenges Port */
    private int portGetAvailableChallenges;

    /** Server port */
    private int serverPort;

    /** Log directory */
    private String logDir;

    /** Compressed log extension */
    private String compressedLogExtension;

    /** Log file size limit */
    private int logFileSizeLimitSize;

    /** Questionnaire Notification Id */
    private int questionnaireNotificationId;

    /** Questionnaire number of questions */
    private int questionnaireNumberOfQuestions;

    /** Witmee data path */
    private String witmeeDataPath;

    /** Experiment start date */
    private String startDate;

    /** Experiment end date*/
    private String endDate;

    /** Weather the experiment is a test or not*/
    private boolean isTest;

    public Configuration(){

    }

    public String getEndpointResultChallenges() {
        return endpointResultChallenges;
    }

    public void setEndpointResultChallenges(String endpointResultChallenges) {
        this.endpointResultChallenges = endpointResultChallenges;
    }

    public int getBluetoothLEScanDuration() {
        return bluetoothLEScanDuration;
    }

    public void setBluetoothLEScanDuration(int bluetoothLEScanDuration) {
        this.bluetoothLEScanDuration = bluetoothLEScanDuration;
    }

    public int getBluetoothLECollectionFrequency() {
        return bluetoothLECollectionFrequency;
    }

    public void setBluetoothLECollectionFrequency(int bluetoothLECollectionFrequency) {
        this.bluetoothLECollectionFrequency = bluetoothLECollectionFrequency;
    }

    public String getEndpointUploadChallengesSynchronizationInfo() {
        return endpointUploadChallengesSynchronizationInfo;
    }

    public void setEndpointUploadChallengesSynchronizationInfo(String endpointUploadChallengesSynchronizationInfo) {
        this.endpointUploadChallengesSynchronizationInfo = endpointUploadChallengesSynchronizationInfo;
    }

    public int getPortGetAvailableChallenges() {
        return portGetAvailableChallenges;
    }

    public void setPortGetAvailableChallenges(int portGetAvailableChallenges) {
        this.portGetAvailableChallenges = portGetAvailableChallenges;
    }

    public String getEndpointUploadReceptionConfirmation() {
        return endpointUploadReceptionConfirmation;
    }

    public void setEndpointUploadReceptionConfirmation(String endpointUploadReceptionConfirmation) {
        this.endpointUploadReceptionConfirmation = endpointUploadReceptionConfirmation;
    }

    public String getEndpointGetAvailableChallenges() {
        return endpointGetAvailableChallenges;
    }

    public void setEndpointGetAvailableChallenges(String endpointGetAvailableChallenges) {
        this.endpointGetAvailableChallenges = endpointGetAvailableChallenges;
    }

    public String getEndpointUploadAnswers() {
        return endpointUploadAnswers;
    }

    public void setEndpointUploadAnswers(String endpointUploadAnswers) {
        this.endpointUploadAnswers = endpointUploadAnswers;
    }

    @JsonProperty(value="isTest")
    public boolean isTest() {
        return isTest;
    }

    @JsonProperty(value="isTest")
    public void setTest(boolean test) {
        isTest = test;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getQuestionnaireNumberOfQuestions() {
        return questionnaireNumberOfQuestions;
    }

    public void setQuestionnaireNumberOfQuestions(int questionnaireNumberOfQuestions) {
        this.questionnaireNumberOfQuestions = questionnaireNumberOfQuestions;
    }

    public String getEndpointLogin() {
        return endpointLogin;
    }

    public void setEndpointLogin(String endpointLogin) {
        this.endpointLogin = endpointLogin;
    }

    public int getLocationCollectionFrequency() {
        return locationCollectionFrequency;
    }

    public void setLocationCollectionFrequency(int locationCollectionFrequency) {
        this.locationCollectionFrequency = locationCollectionFrequency;
    }

    public int getBluetoothScanDuration() {
        return bluetoothScanDuration;
    }

    public void setBluetoothScanDuration(int bluetoothScanDuration) {
        this.bluetoothScanDuration = bluetoothScanDuration;
    }

    public int getApplicationCollectionFrequency() {
        return applicationCollectionFrequency;
    }

    public void setApplicationCollectionFrequency(int applicationCollectionFrequency) {
        this.applicationCollectionFrequency = applicationCollectionFrequency;
    }

    public int getLogFileSizeLimitSize() {
        return logFileSizeLimitSize;
    }

    public void setLogFileSizeLimitSize(int logFileSizeLimitSize) {
        this.logFileSizeLimitSize = logFileSizeLimitSize;
    }

    public String getEndpointUploadProfile() {
        return endpointUploadProfile;
    }

    public void setEndpointUploadProfile(String endpointUploadProfile) {
        this.endpointUploadProfile = endpointUploadProfile;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getCellInfoFrequency() {
        return cellInfoFrequency;
    }

    public void setCellInfoFrequency(int cellInfoFrequency) {
        this.cellInfoFrequency = cellInfoFrequency;
    }

    public int getMainNotificationId() {
        return mainNotificationId;
    }

    public void setMainNotificationId(int mainNotificationId) {
        this.mainNotificationId = mainNotificationId;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public String getEndpointProjects() {
        return endpointProjects;
    }

    public void setEndpointProjects(String endpointProjects) {
        this.endpointProjects = endpointProjects;
    }

    public int getWifiCollectionFrequency() {
        return wifiCollectionFrequency;
    }

    public void setWifiCollectionFrequency(int wifiCollectionFrequency) {
        this.wifiCollectionFrequency = wifiCollectionFrequency;
    }

    public String getWitmeeDataPath() {
        return witmeeDataPath;
    }

    public void setWitmeeDataPath(String witmeeDataPath) {
        this.witmeeDataPath = witmeeDataPath;
    }

    public int getQuestionnaireNotificationId() {
        return questionnaireNotificationId;
    }

    public void setQuestionnaireNotificationId(int questionnaireNotificationId) {
        this.questionnaireNotificationId = questionnaireNotificationId;
    }

    public int getBluetoothCollectionFrequency() {
        return bluetoothCollectionFrequency;
    }

    public void setBluetoothCollectionFrequency(int bluetoothCollectionFrequency) {
        this.bluetoothCollectionFrequency = bluetoothCollectionFrequency;
    }

    public String getCompressedLogExtension(){
        return this.compressedLogExtension;
    }

    public void setCompressedLogExtension(String compressedLogExtension) {
        this.compressedLogExtension = compressedLogExtension;
    }

    public String getEndpointSignup() {
        return endpointSignup;
    }

    public void setEndpointSignup(String endpointSignup) {
        this.endpointSignup = endpointSignup;
    }

    public String getLogDir() {
        return logDir;
    }

    public void setLogDir(String logDir) {
        this.logDir = logDir;
    }

    public String getEndpointUpload() {
        return endpointUpload;
    }

    public void setEndpointUpload(String endpointUpload) {
        this.endpointUpload = endpointUpload;
    }

    public int getMinimumBatteryLevel() {
        return minimumBatteryLevel;
    }

    public void setMinimumBatteryLevel(int minimumBatteryLevel) {
        this.minimumBatteryLevel = minimumBatteryLevel;
    }

    public int getQuestionnaireNotificationInterval() {
        return questionnaireNotificationInterval;
    }

    public void setQuestionnaireNotificationInterval(int questionnaireNotificationInterval) {
        this.questionnaireNotificationInterval = questionnaireNotificationInterval;
    }

    public int getUpdateNotificationId() {
        return updateNotificationId;
    }

    public void setUpdateNotificationId(int updateNotificationId) {
        this.updateNotificationId = updateNotificationId;
    }

    public int getSensorCollectionFrequency() {
        return sensorCollectionFrequency;
    }

    public void setSensorCollectionFrequency(int sensorCollectionFrequency) {
        this.sensorCollectionFrequency = sensorCollectionFrequency;
    }

    public int getLoggingRestartInterval() {
        return loggingRestartInterval;
    }

    public void setLoggingRestartInterval(int loggingRestartInterval) {
        this.loggingRestartInterval = loggingRestartInterval;
    }

    public String getPortSeparator() {
        return portSeparator;
    }

    public void setPortSeparator(String portSeparator) {
        this.portSeparator = portSeparator;
    }

    public boolean isSnoozeNotifications() {
        return snoozeNotifications;
    }

    public void setSnoozeNotifications(boolean snoozeNotifications) {
        this.snoozeNotifications = snoozeNotifications;
    }

    public boolean isBreakNotifications() {
        return breakNotifications;
    }

    public void setBreakNotifications(boolean breakNotifications) {
        this.breakNotifications = breakNotifications;
    }

    public String getServerBaseUrl() {
        return serverBaseUrl;
    }

    public void setServerBaseUrl(String serverBaseUrl) {
        this.serverBaseUrl = serverBaseUrl;
    }

    @Override
    public String toString() {

        return this.toJSONObject().toString();
    }

    public JSONObject toJSONObject(){

        JSONObject objectToReturn = new JSONObject();
        objectToReturn.put("portSeparator", this.portSeparator);
        objectToReturn.put("separator", this.separator);
        objectToReturn.put("snoozeNotifications", this.snoozeNotifications);
        objectToReturn.put("serverBaseUrl", this.serverBaseUrl);
        objectToReturn.put("loggingRestartInterval", this.loggingRestartInterval);
        objectToReturn.put("bluetoothScanDuration", this.bluetoothScanDuration);
        objectToReturn.put("bluetoothLEScanDuration", this.bluetoothLEScanDuration);
        objectToReturn.put("sensorCollectionFrequency", this.sensorCollectionFrequency);
        objectToReturn.put("bluetoothCollectionFrequency", this.bluetoothCollectionFrequency);
        objectToReturn.put("bluetoothLECollectionFrequency", this.bluetoothLECollectionFrequency);
        objectToReturn.put("wifiCollectionFrequency", this.wifiCollectionFrequency);
        objectToReturn.put("applicationCollectionFrequency", this.applicationCollectionFrequency);
        objectToReturn.put("locationCollectionFrequency", this.locationCollectionFrequency);
        objectToReturn.put("cellInfoFrequency", this.cellInfoFrequency);
        objectToReturn.put("updateNotificationId", this.updateNotificationId);
        objectToReturn.put("mainNotificationId", this.mainNotificationId);
        objectToReturn.put("questionnaireNotificationInterval", this.questionnaireNotificationInterval);
        objectToReturn.put("minimumBatteryLevel", this.minimumBatteryLevel);
        objectToReturn.put("endpointUpload", this.endpointUpload);
        objectToReturn.put("endpointUploadAnswers", this.endpointUploadAnswers);
        objectToReturn.put("endpointGetAvailableChallenges", this.endpointGetAvailableChallenges);
        objectToReturn.put("endpointUploadReceptionConfirmation", this.endpointUploadReceptionConfirmation);
        objectToReturn.put("endpointUploadChallengesSynchronizationInfo", this.endpointUploadChallengesSynchronizationInfo);
        objectToReturn.put("endpointResultChallenges", this.endpointResultChallenges);
        objectToReturn.put("endpointSignup", this.endpointSignup);
        objectToReturn.put("endpointLogin", this.endpointLogin);
        objectToReturn.put("endpointUploadProfile", this.endpointUploadProfile);
        objectToReturn.put("endpointProjects", this.endpointProjects);
        objectToReturn.put("portGetAvailableChallenges", this.portGetAvailableChallenges);
        objectToReturn.put("serverPort", this.serverPort);
        objectToReturn.put("logDir", this.logDir);
        objectToReturn.put("compressedLogExtension", this.compressedLogExtension);
        objectToReturn.put("logFileSizeLimitSize", this.logFileSizeLimitSize);
        objectToReturn.put("questionnaireNotificationId", this.questionnaireNotificationId);
        objectToReturn.put("questionnaireNumberOfQuestions", this.questionnaireNumberOfQuestions);
        objectToReturn.put("witmeeDataPath", this.witmeeDataPath);
        objectToReturn.put("startDate", this.startDate);
        objectToReturn.put("endDate", this.endDate);
        objectToReturn.put("isTest", this.isTest);

        return objectToReturn;
    }
}
