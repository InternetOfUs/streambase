package sweb.disi.unitn.it.objects.contributions.iLogQAJsonView;

public class AnswerContentView {

    /** Answer's content as chosen by the i-Log user */
    private String cnt;

    /** Question id */
    private int qid;

    /** Answer id */
    private int aid;

    /** Condition id */
    private int cid;

    public AnswerContentView(){

    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
