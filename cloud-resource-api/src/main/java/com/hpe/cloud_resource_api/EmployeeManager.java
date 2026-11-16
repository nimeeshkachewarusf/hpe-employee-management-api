package com.hpe.cloud_resource_api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    private final Employees employees;

    public EmployeeManager() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(
                "EMP001", "John", "Smith",
                "john.smith@example.com", "Software Engineer"));

        employeeList.add(new Employee(
                "EMP002", "Sarah", "Johnson",
                "sarah.johnson@example.com", "Product Manager"));

        employeeList.add(new Employee(
                "EMP003", "Michael", "Brown",
                "michael.brown@example.com", "Data Analyst"));

        employeeList.add(new Employee(
                "EMP004", "Emily", "Davis",
                "emily.davis@example.com", "Cloud Architect"));

        employees = new Employees(employeeList);
    }

    public Employees getEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.getEmployees().add(employee);
        return employee;
    }
}