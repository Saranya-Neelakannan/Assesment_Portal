package com.main.assessment.concrete;

import java.util.List;

/**
 * Questions
 */
public class Questions {

	private String adminUsername;
	private String answer;
	private List<String> options;
	private String questionId;
	private String questions;

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(String questionId, String questions, String answer, String adminUsername, List<String> options) {
		this.questionId = questionId;
		this.questions = questions;
		this.answer = answer;
		this.adminUsername = adminUsername;
		this.options = options;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public String getAnswer() {
		return answer;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getQuestionId() {
		return questionId;
	}

	public String getQuestions() {
		return questions;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questions=" + questions + ", answer=" + answer
				+ ", adminUsername=" + adminUsername + ", options=" + options + "]";
	}
}