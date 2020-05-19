package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayloadView {

    /** Payload */
    private Payload payload;

    /** Question to which the Payload refers */
    private String qid;

    private PayloadView() {}

    public PayloadView(Payload payload, String qid) {
        this.payload = payload;
        this.qid = qid;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

}