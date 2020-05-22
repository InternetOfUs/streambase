package sweb.disi.unitn.it.objects.contributions;


import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.AnswerContentView;
import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.PayloadView;

import java.util.List;

/** Challenge Answer */
public class ChallengeAnswer {

    private String experimentId;
    private String userId;
    private String instanceid;
    private String instancetimestamp;
    private String notificationtimestamp;
    private String answertimestamp;
    private long delta;
    private long answerduration;
    private List<List<AnswerContentView>> answer;
    private List<PayloadView> payload;
    private String day;

    public ChallengeAnswer(){

    }
    public ChallengeAnswer(String experimentId, String userId, String instanceid, String instancetimestamp, String notificationtimestamp, String answertimestamp,
                           long delta, long answerduration, List<List<AnswerContentView>> answer, List<PayloadView> payload, String day) {
        this.experimentId = experimentId;
        this.userId = userId;
        this.instanceid = instanceid;
        this.instancetimestamp = instancetimestamp;
        this.notificationtimestamp = notificationtimestamp;
        this.answertimestamp = answertimestamp;
        this.delta = delta;
        this.answerduration = answerduration;
        this.answer = answer;
        this.payload = payload;
        this.day = day;
    }

    public String getExperimentId() {
        return experimentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getInstanceid() {
        return instanceid;
    }
    public String getInstancetimestamp() {
        return instancetimestamp;
    }
    public String getNotificationtimestamp() {
        return notificationtimestamp;
    }
    public String getAnswertimestamp() {
        return answertimestamp;
    }
    public long getDelta() {
        return delta;
    }
    public long getAnswerduration() {
        return answerduration;
    }
    public List<List<AnswerContentView>> getAnswer() {
        return answer;
    }
    public List<PayloadView> getPayload() {
        return payload;
    }
    public String getDay() {
        return day;
    }

}
