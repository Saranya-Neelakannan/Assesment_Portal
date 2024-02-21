package com.main.assessment.concrete;

import java.util.List;

/**
 * Admin
 */
public class Admin {
	private String userName;
	private String password;
	private String fullName;
	private List<String> questionGroups;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<String> getQuestionGroups() {
		return questionGroups;
	}

	public void setQuestionGroups(List<String> questionGroups) {
		this.questionGroups = questionGroups;
	}

	public Admin() {

	}

	public Admin(String userName, String password, String fullName, List<String> questionGroups) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.questionGroups = questionGroups;
	}

	@Override
	public String toString() {
		return "Admin [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", questionGroups="
				+ questionGroups + "]";
	}

}