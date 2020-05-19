package sweb.disi.unitn.it.objects.contributions;


import sweb.disi.unitn.it.objects.contributions.iLogQAJsonView.QuestionAnswerView;

import java.util.List;

/**
 * Task questions
 */
public class TaskQuestion {

	private String experimentId;
	private String userId;
	private String instanceid;
	private String day;
	private String instancetimestamp;
	private List<QuestionAnswerView> question;
	private String status;
	private String title;

	public TaskQuestion(){

	}
	public TaskQuestion(String experimentId, String userId, String instanceid, String day, String instancetimestamp, List<QuestionAnswerView> question, String status, String title) {
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

	public String getUserId() {
		return userId;
	}

	public String getInstanceid() {
		return instanceid;
	}

	public String getDay() {
		return day;
	}

	public String getInstancetimestamp() {
		return instancetimestamp;
	}

	public List<QuestionAnswerView> getQuestion() {
		return question;
	}

	public String getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}
}
