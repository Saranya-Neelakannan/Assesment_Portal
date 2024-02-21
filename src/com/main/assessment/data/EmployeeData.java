package com.main.assessment.data;

import java.util.ArrayList;
import java.util.List;

import com.main.assessment.concrete.Employee;

/**
 * EmployeeData
 */
public class EmployeeData {

    private static List<Employee> employees = new ArrayList<>(
        List.of(
            new Employee("ajith", "ahith", "AJITH S", "dhinesh"),
            new Employee("arun", "arun", "ARUN P", "saranya"),
            new Employee("vignesh", "vignesh", "VIGNESHKUMAR M", "dhinesh"),
            new Employee("sathish", "sathish", "SATHISHKUMAR M", "saranya"),
            new Employee("ishu", "ishu", "ISHWARYA C", "dhinesh"),
            new Employee("sindhu", "sindhu", "SINDHU S", "saranya")
        )
    );

    /*
     * to add new employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /*
     * to get all employees
     */
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /*
     * to get employee by username
     */
    public Employee getEmployee(String username) {
        return employees.stream().filter(employee -> employee.getUserName().equals(username)).findFirst().orElse(null);
    }

    /*
     * to get a particular employee by username and password
     */
    public Employee getEmployee(String username, String password) {
        return employees.stream()
                .filter(employee -> employee.getUserName().equals(username) && employee.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    
}