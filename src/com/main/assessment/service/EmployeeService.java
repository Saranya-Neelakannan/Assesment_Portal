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
	private Employee emp;
	EmployeeData employeeData = new EmployeeData();
	Questions questions = new Questions();
	QuestionsData questionsData = new QuestionsData();
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public void beginAssesment() throws NumberFormatException, IOException {
		System.out.print("Enter the groupId : ");
		String groupId = reader.readLine();
		if (emp.getAssesmentStatus().size() == 0) {
			System.out.println("There are no assessments assigned.");
		} else {
			if (!emp.getAssesmentStatus().containsKey(groupId)) {
				System.out.println("There are no assessments assigned under the group id.!!!");
			} else if (emp.getAssesmentStatus().get(groupId).equals("completed")) {
				System.out.println("You have already attended this questions.");
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
		System.out.println("Your Percentage : " + marks + " %.");
		emp.setAsssementMarks(grpId, marks);
		emp.updateAssessmentStatus(grpId, "completed");
	}

	public Map<String, Double> getAssesmentMarks() {
		return emp.getAsssementMarks();
	}

	public Map<String, String> getAssesmentStatus() {
		return emp.getAssesmentStatus();
	}

	public boolean getEmployee(String username) {
		return employeeData.getEmployee(username) == null;
	}

	public boolean login(String userName, String password) {
		this.emp = employeeData.getEmployee(userName, password);
		if (this.emp != null) {
			return true;
		} else {
			return false;
		}
	}

	public void printAssesmentMarks(String username) {
		System.out.println(username + "Assesment Marks: " + emp.getAsssementMarks());
	}

	private List<String> printQuestions(List<Questions> questionList) throws NumberFormatException, IOException {
		int sNo = 1, optionCount = 1;
		List<String> answerList = new ArrayList<>();
		for (Questions q : questionList) {
			System.out.println(sNo++ + ".)  " + q.getQuestions());
			optionCount = 1;
			for (String i : q.getOptions()) {
				System.out.print("\t" + optionCount++ + ".) " + i + "\t");
			}
			System.out.println();
			System.out.println();
			System.out.print("Enter any one of the option : ");
			int option = Integer.parseInt(reader.readLine());
			answerList.add(q.getOptions().get(option - 1));
			System.out.println();
			System.out.println();
		}
		return answerList;

	}

	public void register(Employee employee) {
		emp = employee;
		employeeData.addEmployee(employee);

	}

	public void viewCompletedAssesment() {
		List<Map.Entry<String, String>> assessmentStatus = emp.getAssesmentStatus().entrySet().stream()
				.filter(employee -> employee.getValue().equals("completed")).toList();
		if (assessmentStatus.size() != 0) {
			assessmentStatus.forEach(System.out::println);
		} else {
			System.out.println("There are no completed assessments.!!!");
		}
	}

	public void viewParticularMarks(String groupId) {
		List<Map.Entry<String, Double>> assessmentMarks = emp.getAsssementMarks().entrySet().stream()
				.filter(employee -> employee.getKey().equals(groupId)).toList();

		if (assessmentMarks.size() != 0) {
			assessmentMarks.forEach(System.out::println);
		} else {
			System.out.println("There are no completed assessments.!!!");
		}
	}

	public void viewPendingAssesments() {
		List<Map.Entry<String, String>> assessmentStatus = emp.getAssesmentStatus().entrySet().stream()
				.filter(employee -> employee.getValue().equals("pending")).toList();
		if (assessmentStatus.size() != 0) {
			assessmentStatus.forEach(System.out::println);
		} else {
			System.out.println("There are no pending assessments.!!!");
		}
	}

}