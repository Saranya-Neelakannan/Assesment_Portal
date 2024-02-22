package com.main.assessment.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.main.assessment.concrete.Admin;
import com.main.assessment.concrete.Employee;
import com.main.assessment.concrete.Questions;
import com.main.assessment.data.AdminData;
import com.main.assessment.data.EmployeeData;
import com.main.assessment.data.QuestionsData;
import com.main.assessment.exceptions.AssessmentNotFoundException;
import com.main.assessment.exceptions.EmployeeNotFoundException;

/**
 * AdminService
 */
public class AdminService {
	private Admin admin = new Admin();
	private AdminData adminData = new AdminData();
	private EmployeeData employeeData = new EmployeeData();
	private QuestionsData qData = new QuestionsData();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/*
	 * to assign the questions to an employee
	 */
	public String assignAssessmentToEmployee(String username, String groupName) {
		Employee employee = employeeData.getEmployee(username);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not Found");
		} else if (qData.getQuestionsByGroupId(groupName).size() == 0) {
			throw new AssessmentNotFoundException("There are no question group associated with mentioned name.!!!");
		}
		else if (employee.getAdminUsername().equals(admin.getUserName())) {
			String status = employee.getAssesmentStatus().get(groupName);
			if (status == null) {
				employee.setAssesmentStatus(groupName, "pending");
				return "assigned";
			} else if (status == "pending") {
				return "assessment-pending";
			} else {
				employee.setAssesmentStatus(groupName, "pending");
				return "assigned";
			}
		} else {
			throw new EmployeeNotFoundException("Employee not associated with your username.!!!");
		}
	}

	/*
	 * to create a new group of questions.
	 */
	public boolean createQuestionGroup() throws IOException {
		System.out.print("Enter the name of the Question group : ");
		String groupId = reader.readLine();
		if (qData.getQuestionsByGroupId(groupId).size() == 0) {
			System.out.print("Enter the no of questions you want to add : ");
			int noOfQuestions = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= noOfQuestions; i++) {
				getQuestions(groupId, String.valueOf(i));
			}
			return true;
		} else {
			return false;
		}
	}

	/*
	 * to get a particular question from the admin
	 */
	private void getQuestions(String qGroupName, String count) throws IOException {
		String qId = qGroupName + count;
		System.out.print(count + ".) Enter the question : ");
		String question = reader.readLine();
		System.out.print("Enter the answer of the question " + count + " : ");
		String answer = reader.readLine();
		System.out.print("Enter the Options of the above question -> ");
		List<String> options = new ArrayList<>();
		System.out.println();
		for (int i = 0; i < 4; i++) {
			System.out.print("Option " + (i + 1) + " : ");
			options.add(reader.readLine());
			System.out.println();
		}
		qData.addQuestion(new Questions(qId, question, answer, admin.getUserName(), options));
	}

	/*
	 * to login the admin
	 */
	public boolean login(String username, String password) {
		admin = adminData.getAdmin(username, password);
		if (admin != null) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * to view all employees
	 */
	public void viewAllEmployees() {
		List<Employee> employees = employeeData.getAllEmployees().stream()
				.filter(employee -> employee.getAdminUsername().equals(admin.getUserName())).toList();
		if (employees.size() != 0) {
			employees.forEach(System.out::println);
		} else {
			throw new EmployeeNotFoundException("There are no employees.!!!");
		}
	}

	/*
	 * to view all questions
	 */
	public void viewAllQuestions() {
		List<Questions> questions = qData.getAllQuestions().stream()
				.filter(question -> question.getAdminUsername().equals(admin.getUserName())).toList();
		if (questions.size() != 0) {
			questions.forEach(System.out::println);
		} else {
			throw new AssessmentNotFoundException("There are no Assessments");
		}
	}

	/*
	 * to view questions by group name
	 */
	public void viewQuestionsByGroupName(String groupName) {
		List<Questions> questions = qData.getQuestionsByGroupId(groupName).stream()
				.filter(question -> question.getAdminUsername().equals(admin.getUserName())).toList();
		if (questions.size() != 0) {
			questions.forEach(System.out::println);
		} else {
			throw new AssessmentNotFoundException("There are no Assessments associated with the mention group Name");
		}
	}

}