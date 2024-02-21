package com.main.assessment.controller;

import java.io.BufferedReader;
import java.io.IOException;

import com.main.assessment.concrete.Employee;
import com.main.assessment.data.EmployeeData;
import com.main.assessment.exceptions.AdminNotFoundException;
import com.main.assessment.service.EmployeeService;
import com.main.assessment.utilities.Utils;

/**
 * EmployeeController
 */

// "1.Login.\n2.Register.\n3.Begin Assessment.\n4.View all Assessments.\n5.View Pending Assessments.\n6.View Completed Assessments.\n7.View all Assessment Marks.\n8.View Particular Question Group Assessment Mark.\n");

public class EmployeeController {
	public EmployeeController(BufferedReader reader) {
        this.reader = reader;
    }
	EmployeeService employeeService =new EmployeeService();
	EmployeeData employeeData=new EmployeeData();

    private BufferedReader reader;
    Employee employee;
    String userName;
    String password;
    String fullName;
    String groupId;
    

    public void start() {
    	try {
			employeeLogin();
			
			do {
				Utils.employeeMenu();
                System.out.print("Enter your choice : ");
                switch (Integer.parseInt(reader.readLine())) {
                    case 1:
                    	System.out.println("Enter username");
                    	userName=reader.readLine();
                    	System.out.println("Enter password");
                    	password=reader.readLine();
                    	
                    	
                        employeeService.login(userName, password);
                        break;

                    case 2:
                    	System.out.println("Enter username");
                    	userName=reader.readLine();
                    	Employee userExists=employeeData.getEmployee(userName);
                    	if(userExists ==null) {
                    		System.out.println("UserName dos not exist");
                    	}
                    	else
                    	{
                    	System.out.println("Enter password");
                    	password=reader.readLine();
                    	System.out.println("Enter fullname");
                    	fullName=reader.readLine();
                    	
                    	Employee employee=new Employee(userName,password,fullName);
                        employeeService.register(employee);
                    	}
                        break;

                    case 3:
                        employeeService.beginAssesment();

                    case 4:
                    	System.out.println(employee.getAssesmentStatus());
                    	break;
                    case 5:
                    	viewPendingAssesments();
                    	break;
                    case 6:
                    	viewCompletedAssesment();
                    	break;
                    case 7:
                        System.out.println(employee.getAsssementMarks());
                    	break;
                    case 8:
                    	System.out.println("Enter the groupId");
                    	groupId=reader.readLine();
                    	viewParticularMarks(groupId);
                    	break;
                    		
                    default:
                    	
                        break;
                }
                System.out.print("Enter 'Y' or 'y' to continue or else to log out : ");
            } while (reader.readLine().toLowerCase().charAt(0) == 'y');

    	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    }
    

	
	
	private void viewPendingAssesments() {
		}
	
	
	private void viewCompletedAssesment(){
	}
	
	
	private void viewParticularMarks(String groupId) {
	}
	
	
	
	
	
	private boolean employeeLogin() throws IOException {
        System.out.print("Enter the username : ");
        userName = reader.readLine();

        System.out.print("Enter the password : ");
        password = reader.readLine();
        if (employeeService.login(userName, password)) {
            return true;
        } else {
            throw new AdminNotFoundException("UnAuthorized Admin...!");
        }
    }

}