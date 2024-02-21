package com.main.assessment.controller;

import com.main.assessment.exceptions.AdminNotFoundException;
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
	private String username, password;

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
					adminService.viewAllEmployees();
					break;

				case 2:
					adminService.viewAllQuestions();
					break;

				case 3:
					System.out.print("Enter the Group name to view Questions :  ");
					String groupName = reader.readLine();
					adminService.viewQuestionsByGroupName(groupName);
					break;

				case 4:
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
					}
					break;

				case 5:
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