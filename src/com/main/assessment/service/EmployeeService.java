package com.main.assessment.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.main.assessment.concrete.Employee;
import com.main.assessment.concrete.Questions;
import com.main.assessment.data.EmployeeData;
import com.main.assessment.data.QuestionsData;

/**
 * EmployeeService
 */
public class EmployeeService {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	EmployeeData employeeData = new EmployeeData();
	QuestionsData questionsData = new QuestionsData();
	Questions questions = new Questions();
	private Employee emp;

	public boolean login(String userName, String password) {
		this.emp = employeeData.getEmployee(userName, password);
		System.out.println(emp);

		if (this.emp != null) {
			return true;
		} else {
			return false;
		}
	}

	public void register(Employee employee) {
		emp = employee;
		employeeData.addEmployee(employee);

	}

	public void printAssesmentMarks(String username) {
		System.out.println(username + "Assesment Marks: " + emp.getAsssementMarks());
	}

	public void beginAssesment() throws NumberFormatException, IOException {

		System.out.println("Enter the groupId");
		String groupId = reader.readLine();
		if (emp.getAssesmentStatus().size() == 0) {
			System.out.println("There are no assessments assigned.");
		} else {
			if (emp.getAssesmentStatus().get(groupId).equals("completed")) {
				System.out.println("You have already");
			} else {
				List<Questions> questionList = questionsData.getQuestionsByGroupId(groupId);
				List<String> answerList = printQuestions(questionList);
				calculateMarks(answerList, groupId, questionList);

			}
		}

	}

	private void calculateMarks(List<String> answerList, String grpId, List<Questions> questions) {
		double marks = 0.0;
		for (int i = 0; i < answerList.size(); i++) {
			if (answerList.get(i).equals(questions.get(i).getAnswer())) {
				marks++;
			}
		}
		marks = (marks / questions.size()) * 100;
		emp.setAsssementMarks(grpId, marks);
		emp.updateAssessmentStatus(grpId, "completed");

	}

	private List<String> printQuestions(List<Questions> questionList) throws NumberFormatException, IOException {
		int sNo = 1, oCount = 1;
		List<String> answerList = new ArrayList<>();
		for (Questions q : questionList) {
			System.out.println(sNo + "  " + q.getQuestions());
			oCount = 1;
			for(String i : q.getOptions()) {
				System.out.print(oCount++ + ". " + i + " ");
			}
			System.out.println("Enter any one of the option");
			int option = Integer.parseInt(reader.readLine());
			answerList.add(q.getOptions().get(option - 1));
			sNo++;
		}
		return answerList;

	}

	public Map<String, String> getAssesmentStatus() {
		return emp.getAssesmentStatus();
	}

	public Map<String, Double> getAssesmentMarks() {
		return emp.getAsssementMarks();
	}

	
	public void viewPendingAssesments() {
		for(String i : emp.getAssesmentStatus().values()) {
			if(i.equals("pending")) {
				System.out.println(emp.getAssesmentStatus().get(i));
			}
		}
	}

	public void viewCompletedAssesment() {
		for(String i : emp.getAssesmentStatus().values()) {
			if(i.equals("completed")) {
				System.out.println(emp.getAssesmentStatus().get(i));
			}
		}
	}

	public void viewParticularMarks(String groupId) {
		for(String i : emp.getAsssementMarks().keySet()) {
			if(i.equals(groupId)) {
				System.out.println(emp.getAsssementMarks().get(i));
			}
		}
	}

}