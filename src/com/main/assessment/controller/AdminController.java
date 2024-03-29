package com.main.assessment.controller;

import com.main.assessment.exceptions.AdminNotFoundException;
import com.main.assessment.exceptions.AssessmentNotFoundException;
import com.main.assessment.exceptions.EmployeeAlreadyExistException;
import com.main.assessment.exceptions.EmployeeNotFoundException;
import com.main.assessment.service.AdminService;
import com.main.assessment.utilities.Utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * AdminController
 */
public class AdminController {

	private AdminService adminService = new AdminService();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private String username, password, groupName, fullName;

	/*
	 * to validate the admin credentials
	 */
	private boolean adminLogin() throws IOException {
		System.out.print("Enter the username : ");
		username = reader.readLine();

		System.out.print("Enter the password : ");
		password = reader.readLine();
		if (adminService.login(username, password)) {
			return true;
		} else {
			throw new AdminNotFoundException("UnAuthorized Admin...!");
		}
	}

	/*
	 * the start method which is going to be execute first
	 */
	public void start() throws IOException {
		try {
			adminLogin();
			do {
				Utils.adminMenu();
				System.out.print("Enter your choice : ");
				switch (Integer.parseInt(reader.readLine())) {
				case 1:
					try {
						System.out.print("Enter the username : ");
						username = reader.readLine();
						System.out.print("Enter the password : ");
						password = reader.readLine();
						System.out.print("Enter the Fullname : ");
						fullName = reader.readLine();
						adminService.addNewEmployee(username, password, fullName);
						System.out.println("Employee Added Successfully.!!!");
					} catch (EmployeeAlreadyExistException e) {
						System.out.println(e);
					}
					break;

				case 2:
					try {
						System.out.print("Enter the username : ");
						username = reader.readLine();
						adminService.deleteEmployee(username);
						System.out.println("Employee Deleted Successfully.!!!");
					} catch (EmployeeNotFoundException e) {
						System.out.println(e);
					}
					break;
					
				case 3:
					try {
						adminService.viewAllEmployees();
					} catch (EmployeeNotFoundException e) {
						System.out.println(e);
					}
					break;

				case 4:
					try {
						adminService.viewAllQuestions();
					} catch (AssessmentNotFoundException e) {
						System.out.println(e);
					}
					break;

				case 5:
					try {
						System.out.print("Enter the Group name to view Questions :  ");
						groupName = reader.readLine();
						adminService.viewQuestionsByGroupName(groupName);

					} catch (AssessmentNotFoundException e) {
						System.out.println(e);
					}
					break;

				case 6:
					System.out.print("Enter the username of the employee : ");
					username = reader.readLine();
					System.out.print("Enter the question group name to assign to that employee : ");
					groupName = reader.readLine();
					try {
						String result = adminService.assignAssessmentToEmployee(username, groupName);
						if (result.equals("assigned")) {
							System.out.println("Assignment assigned to that employee.");
						} else {
							System.out.println("The mentioned assessment are already pending in that employee.");
						}
					} catch (EmployeeNotFoundException e) {
						System.out.println(e);
					} catch (AssessmentNotFoundException e) {
						System.out.println(e);
					}
					break;

				case 7:
					boolean result = adminService.createQuestionGroup();
					if (result) {
						System.out.println("Question Group Created.!!!");
					} else {
						System.out.println("Already the name was associated in another group.!!!");
					}
					break;

				default:
					break;
				}
				System.out.print("Enter 'Y' or 'y' to continue to admin panel or else to log out : ");
			} while (reader.readLine().toLowerCase().charAt(0) == 'y');
		} catch (AdminNotFoundException e) {
			System.out.println(e);
			System.out.println();
			System.out.print("Enter 'Y' or 'y' to retry or else to go back : ");
			if (reader.readLine().toLowerCase().charAt(0) == 'y') {
				start();
			}
		}
	}
}