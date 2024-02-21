package com.main.assessment.data;

import java.util.ArrayList;
import java.util.List;

import com.main.assessment.concrete.Employee;

/**
 * EmployeeData
 */
public class EmployeeData {

    private static List<Employee> employees = new ArrayList<>();

    /*
     * to get all employees
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /*
     * to get a particular employee by username and password
     */
    public Employee getEmployee(String username, String password) {
        return employees.stream()
                .filter(employee -> employee.getUserName().equals(username) && employee.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    /*
     * to add new employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    
}