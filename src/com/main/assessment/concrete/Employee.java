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

	public void setAssesmentStatus(String groupName, String status) {
		this.assesmentStatus.put(groupName, status);
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

	public void setAsssementMarks(Map<String, Double> asssementMarks) {
		this.asssementMarks = asssementMarks;
	}

	public Employee(String userName, String password, String fullName, Map<String, Double> asssementMarks,
			Map<String, String> assesmentStatus) {

		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.asssementMarks = asssementMarks;
		this.assesmentStatus = assesmentStatus;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", asssementMarks=" + asssementMarks + ", assesmentStatus=" + assesmentStatus + "]";
	}

}