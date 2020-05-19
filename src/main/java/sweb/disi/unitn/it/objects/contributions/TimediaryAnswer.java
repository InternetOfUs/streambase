package sweb.disi.unitn.it.objects.contributions;


import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.AnswerContentView;
import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.PayloadView;

import java.util.List;

/** Timediary Answer */
public class TimediaryAnswer extends ChallengeAnswer {

    public TimediaryAnswer(){

    }
    public TimediaryAnswer(String experimentId, String userId, String instanceid, String instancetimestamp, String notificationtimestamp, String answertimestamp,
                           long delta, long answerduration, List<List<AnswerContentView>> answer, List<PayloadView> payload, String day) {
        super(experimentId, userId, instanceid, instancetimestamp, notificationtimestamp, answertimestamp, delta, answerduration, answer, payload, day);
    }   
}

