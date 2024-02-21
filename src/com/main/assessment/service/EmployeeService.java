package com.main.assessment.service;

import com.main.assessment.concrete.Employee;
import com.main.assessment.data.EmployeeData;

/**
 * EmployeeService
 */
public class EmployeeService {
	EmployeeData employeeData=new EmployeeData();
	Employee emp;
    public boolean login(String userName,String password) {
    	emp=employeeData.getEmployee(userName,password);
    	
    	if(emp!=null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public void register(Employee employee) {
    	employeeData.addEmployee(employee);
 
    }
    
    public void printAssesmentMarks(String username) {
    	System.out.println(username +"Assesment Marks: "+emp.getAsssementMarks());
    }
    
    public void beginAssesment() {
    	
    }
    
}