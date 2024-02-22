package com.main.assessment.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import com.main.assessment.concrete.Employee;
import com.main.assessment.exceptions.EmployeeNotFoundException;
import com.main.assessment.service.EmployeeService;
import com.main.assessment.utilities.Utils;

/**
 * EmployeeController
 */

// "1.Login.\n2.Register.\n3.Begin Assessment.\n4.View all Assessments.\n5.View
// Pending Assessments.\n6.View Completed Assessments.\n7.View all Assessment
// Marks.\n8.View Particular Question Group Assessment Mark.\n");

public class EmployeeController {

	private EmployeeService employeeService = new EmployeeService();
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private String username, password, fullName, adminUsername, groupId;

	private boolean employeeLogin() throws IOException {
		System.out.print("Enter the username : ");
		username = reader.readLine();

		System.out.print("Enter the password : ");
		password = reader.readLine();
		if (employeeService.login(username, password)) {
			return true;
		} else {
			throw new EmployeeNotFoundException("UnAuthorized Employee...!");
		}
	}

	public void start() throws IOException {
		try {
			do {
				System.out.println("1.Login.\n2.Register.\n");
				System.out.print("Enter your choice : ");
				switch (Integer.parseInt(reader.readLine())) {
				case 1:
					employeeLogin();
					break;

				case 2:
					System.out.print("Enter the username");
					username = reader.readLine();
					if (employeeService.getEmployee(username)) {
						System.out.print("Enter the password");
						password = reader.readLine();
						System.out.print("Enter the Fullname");
						fullName = reader.readLine();
						System.out.print("Enter the username of your admin : ");
						adminUsername = reader.readLine();

						employeeService.register(new Employee(username, password, fullName, adminUsername));
					} else {
						System.out.println("Username already exist");
					}
					break;

				default:
					break;
				}
				do {
					Utils.employeeMenu();
					System.out.print("Enter your choice : ");
					switch (Integer.parseInt(reader.readLine())) {
					case 1:
						employeeService.beginAssesment();
						break;

					case 2:
						System.out.println(employeeService.getAssesmentStatus());
						break;
					case 3:
						employeeService.viewPendingAssesments();
						break;
					case 4:
						employeeService.viewCompletedAssesment();
						break;
					case 5:
						System.out.println(employeeService.getAssesmentMarks());
						break;
					case 6:
						System.out.print("Enter the groupId : ");
						groupId = reader.readLine();
						employeeService.viewParticularMarks(groupId);
						break;

					default:
						break;
					}
					System.out.print("Enter 'Y' or 'y' to continue the current employee or else to log out : ");
				} while (reader.readLine().toLowerCase().charAt(0) == 'y');

				System.out.print("Enter 'Y' or 'y' to continue in the employee panel or else to log out : ");
			} while (reader.readLine().toLowerCase().charAt(0) == 'y');
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
	}

}