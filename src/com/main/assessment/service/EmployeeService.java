package com.main.assessment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.main.assessment.concrete.Employee;
import com.main.assessment.concrete.Questions;
import com.main.assessment.data.EmployeeData;
import com.main.assessment.data.QuestionsData;

/**
 * EmployeeService
 */
public class EmployeeService {
	BufferedReader reader;

	public EmployeeService(BufferedReader reader) {
		this.reader = reader;
	}

	public EmployeeService() {
			}

	EmployeeData employeeData = new EmployeeData();
	QuestionsData questionsData = new QuestionsData();
	Questions questions = new Questions();
	Employee emp;

	public boolean login(String userName, String password) {
		emp = employeeData.getEmployee(userName, password);

		if (emp != null) {
			return true;
		} else {
			return false;
		}
	}

	public void register(Employee employee) {
		employeeData.addEmployee(employee);

	}

	public void printAssesmentMarks(String username) {
		System.out.println(username + "Assesment Marks: " + emp.getAsssementMarks());
	}

	public void beginAssesment() throws NumberFormatException, IOException {

		
		System.out.println("Enter the groupId");
		String groupId = reader.readLine();
		if(emp.getAssesmentStatus().get(groupId).equals("completed")) {
			System.out.println("You have aldready");
		}
		else {
		List<Questions> questionList = questionsData.getQuestionsByGroupId(groupId);
		List<String> answerList = printQuestions(questionList);

		calculateMarks(answerList, groupId);
		
	}

	}

	private void calculateMarks(List<String> answerList, String grpId) {
		double marks = 0.0;
		for (int i = 0; i < answerList.size(); i++) {
			if (answerList.get(i).equals(questions.getAnswer())) {
				marks++;
			}
		}
		marks = (marks / answerList.size()) * 100;
		emp.setAsssementMarks(grpId, marks);
		emp.updateAssessmentStatus(grpId, "completed");

	}

	private List<String> printQuestions(List<Questions> questionList) throws NumberFormatException, IOException {
		int sNo = 0;
		List<String> answerList = new ArrayList<>();
		for (Questions q : questionList) {
			System.out.println(sNo + "  " + q.getQuestions());
			System.out.println(q.getOptions());
			System.out.println("Enter any one of the option");
			int option = Integer.parseInt(reader.readLine());
			answerList.add(q.getOptions().get(option));
			sNo++;
		}
		return answerList;

	}

}