package sweb.disi.unitn.it.objects.contributions;


import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.AnswerContentView;
import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.PayloadView;

import java.util.List;

/**
 * Task answers
 */
public class TaskAnswer extends ChallengeAnswer {

    public TaskAnswer(){

    }
    public TaskAnswer(String experimentId, String userId, String instanceid, String instancetimestamp, String notificationtimestamp, String answertimestamp,
                      long delta, long answerduration, List<List<AnswerContentView>> answer, List<PayloadView> payload, String day) {
        super(experimentId, userId, instanceid, instancetimestamp, notificationtimestamp, answertimestamp, delta, answerduration, answer, payload, day);
    }   
}
