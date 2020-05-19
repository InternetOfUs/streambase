package sweb.disi.unitn.it.objects.contributions;


import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.QuestionAnswerView;

import java.util.List;

/**
 * Timediary questions
 */
public class TimediaryQuestion {

    private String experimentId;
    private String userId;
    private String instanceid;
    private String day;
    private String instancetimestamp;
    private List<QuestionAnswerView> question;
    private String status;
    private String title;

    public TimediaryQuestion(){

    }
    public TimediaryQuestion(String experimentId, String userId, String instanceid, String day, String instancetimestamp, List<QuestionAnswerView> question, String status, String title) {
        this.experimentId = experimentId;
        this.userId = userId;
        this.instanceid = instanceid;
        this.day = day;
        this.instancetimestamp = instancetimestamp;
        this.question = question;
        this.status = status;
        this.title = title;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getInstancetimestamp() {
        return instancetimestamp;
    }

    public void setInstancetimestamp(String instancetimestamp) {
        this.instancetimestamp = instancetimestamp;
    }

    public List<QuestionAnswerView> getQuestion() {
        return question;
    }

    public void setQuestion(List<QuestionAnswerView> question) {
        this.question = question;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
