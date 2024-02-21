package com.main.assessment;

import java.io.InputStreamReader;

import com.main.assessment.controller.AdminController;
import com.main.assessment.controller.EmployeeController;
import com.main.assessment.utilities.Utils;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * AssessmentPortal
 */
public class AssessmentPortal {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			Utils.initialMenu();
			System.out.print("Enter the choice : ");
			switch (Integer.parseInt(reader.readLine())) {
			case 1:
				AdminController adminController = new AdminController();
				adminController.start();
				break;

			case 2:
				EmployeeController employeeController = new EmployeeController();
				employeeController.start();
				break;

			case 3:
				System.exit(0);
			default:
				System.out.println("Enter valid choice...!");
				break;
			}
		}
	}
}