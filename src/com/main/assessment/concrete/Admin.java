package com.main.assessment.concrete;

import java.util.List;

/**
 * Admin
 */
public class Admin {
	private String fullName;
	private String password;
	private List<String> questionGroups;
	private String userName;

	public Admin() {

	}

	public Admin(String userName, String password, String fullName, List<String> questionGroups) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.questionGroups = questionGroups;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public List<String> getQuestionGroups() {
		return questionGroups;
	}

	public String getUserName() {
		return userName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQuestionGroups(List<String> questionGroups) {
		this.questionGroups = questionGroups;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", questionGroups="
				+ questionGroups + "]";
	}

}