package sweb.disi.unitn.it.objects.contributions;


import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.PayloadView;

import java.util.List;

/** Challenge Subscription */
public class ChallengeSubscription {

    private String experimentId;
    private String userId;
    private String instanceid;
    private String status;
    private List<PayloadView> payload;
    private String timestamp;

    public ChallengeSubscription(){

    }

    public ChallengeSubscription(String experimentId, String userId, String instanceid, String status, List<PayloadView> payload, String timestamp){

        this.experimentId = experimentId;
        this.userId = userId;
        this.instanceid = instanceid;
        this.status = status;
        this.payload = payload;
        this.timestamp = timestamp;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayload(List<PayloadView> payload) {
        this.payload = payload;
    }

    public List<PayloadView> getPayload() {
        return payload;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
