package com.main.assessment.concrete;

import java.util.Map;

/**
 * Employee
 */
public class Employee {
	private String userName;
	private String password;
	private String fullName;
	private Map<String, Double> asssementMarks;
	private Map<String, String> assesmentStatus;

	public Map<String, String> getAssesmentStatus() {
		return assesmentStatus;
	}

	public void setAssesmentStatus(String groupId, String status) {
		this.assesmentStatus.put(groupId, status);
	}

	public void updateAssessmentStatus(String groupId, String status) {
		this.assesmentStatus.replace(groupId, status);
	}

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

	public Map<String, Double> getAsssementMarks() {
		return asssementMarks;
	}

	public void setAsssementMarks(String groupId, double marks) {
		this.asssementMarks.put(groupId, marks);
	}

	public Employee(String userName, String password, String fullName){
 

		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
	
		
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", asssementMarks=" + asssementMarks + ", assesmentStatus=" + assesmentStatus + "]";
	}

}