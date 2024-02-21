package com.main.assessment.concrete;

import java.util.Map;
import java.util.HashMap;

/**
 * Employee
 */
public class Employee {
	private String adminUsername;
	private Map<String, String> assesmentStatus;
	private Map<String, Double> asssementMarks;
	private String fullName;
	private String password;
	private String userName;

	public Employee() {

	}

	public Employee(String userName, String password, String fullName, String adminUsername) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.adminUsername = adminUsername;
		this.asssementMarks = new HashMap<>();
		this.assesmentStatus = new HashMap<>();
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public Map<String, String> getAssesmentStatus() {
		return assesmentStatus;
	}

	public Map<String, Double> getAsssementMarks() {
		return asssementMarks;
	}

	public String getFullName() {
		return fullName;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public void setAssesmentStatus(Map<String, String> assesmentStatus) {
		this.assesmentStatus = assesmentStatus;
	}

	public void setAssesmentStatus(String groupId, String status) {
		this.assesmentStatus.put(groupId, status);
	}

	public void setAsssementMarks(Map<String, Double> asssementMarks) {
		this.asssementMarks = asssementMarks;
	}

	public void setAsssementMarks(String groupId, double marks) {
		this.asssementMarks.put(groupId, marks);
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", adminUsername=" + adminUsername + ", asssementMarks=" + asssementMarks + ", assesmentStatus="
				+ assesmentStatus + "]";
	}

	public void updateAssessmentStatus(String groupId, String status) {
		this.assesmentStatus.replace(groupId, status);
	}

}