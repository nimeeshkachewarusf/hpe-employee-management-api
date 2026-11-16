package com.hpe.cloud_resource_api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    // GET: Retrieve all employees
    @GetMapping
    public Employees getEmployees() {
        return employeeManager.getEmployees();
    }

    // POST: Add a new employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeManager.addEmployee(employee);
    }
}