package com.main.assessment.concrete;

import java.util.List;

/**
 * Questions
 */
public class Questions {

	private String questionId;
	private String questions;
	private String answer;
	private List<String> options;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getAnswer() {
		return answer;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Questions(String questionId, String questions, String answer, List<String> options) {
		super();
		this.questionId = questionId;
		this.questions = questions;
		this.answer = answer;
		this.options = options;
	}

	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questions=" + questions + ", answer=" + answer + ", options="
				+ options + "]";
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}
}