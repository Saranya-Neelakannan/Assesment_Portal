package com.main.assessment.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.main.assessment.concrete.Employee;
import com.main.assessment.data.EmployeeData;
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

	EmployeeService employeeService = new EmployeeService();
	EmployeeData employeeData = new EmployeeData();

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	Employee employee;
	String userName;
	String password;
	String fullName;
	String groupId;

	public void start() throws IOException {
		System.out.println("1.Login.\n2.Register.\n");
		switch (Integer.parseInt(reader.readLine())) {
			case 1:
				employeeLogin();
				break;

			case 2:
				System.out.println("Enter username");
				userName = reader.readLine();
				Employee userExists = employeeData.getEmployee(userName);
				if (userExists != null) {
					System.out.println("UserName dos not exist");
				} else {
					System.out.println("Enter password");
					password = reader.readLine();
					System.out.println("Enter fullname");
					fullName = reader.readLine();

					Employee employee = new Employee(userName, password, fullName);
					employeeService.register(employee);
				}
				break;

			default:
				break;
		}
		try {
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
						System.out.println("Enter the groupId");
						groupId = reader.readLine();
						employeeService.viewParticularMarks(groupId);
						break;

					default:
						break;
				}
				System.out.print("Enter 'Y' or 'y' to continue or else to log out : ");
			} while (reader.readLine().toLowerCase().charAt(0) == 'y');

		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
	}


	private boolean employeeLogin() throws IOException {
		System.out.print("Enter the username : ");
		userName = reader.readLine();

		System.out.print("Enter the password : ");
		password = reader.readLine();
		if (employeeService.login(userName, password)) {
			return true;
		} else {
			throw new EmployeeNotFoundException("UnAuthorized Employee...!");
		}
	}

}