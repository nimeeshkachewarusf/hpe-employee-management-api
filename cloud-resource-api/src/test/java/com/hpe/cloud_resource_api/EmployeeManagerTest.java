package com.hpe.cloud_resource_api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        employeeManager = new EmployeeManager();
    }

    // Test 4: Initial employee list exists
    @Test
    void testInitialEmployees() {

        Employees employees = employeeManager.getEmployees();

        assertNotNull(employees);
        assertNotNull(employees.getEmployees());
        assertEquals(4, employees.getEmployees().size());
    }

    // Test 5: Adding an employee increases list size
    @Test
    void testAddEmployee() {

        int initialSize = employeeManager
                .getEmployees()
                .getEmployees()
                .size();

        Employee employee = new Employee(
                "EMP005", "Alex", "Wilson",
                "alex@example.com", "Engineer");

        employeeManager.addEmployee(employee);

        int newSize = employeeManager
                .getEmployees()
                .getEmployees()
                .size();

        assertEquals(initialSize + 1, newSize);
    }

    // Test 6: Added employee data is correct
    @Test
    void testAddedEmployeeData() {

        Employee employee = new Employee(
                "EMP006", "Emily", "Davis",
                "emily@example.com", "Cloud Engineer");

        employeeManager.addEmployee(employee);

        Employee lastEmployee = employeeManager
                .getEmployees()
                .getEmployees()
                .get(employeeManager.getEmployees()
                        .getEmployees().size() - 1);

        assertEquals("EMP006", lastEmployee.getEmployee_id());
        assertEquals("Emily", lastEmployee.getFirst_name());
        assertEquals("Davis", lastEmployee.getLast_name());
        assertEquals("emily@example.com", lastEmployee.getEmail());
        assertEquals("Cloud Engineer", lastEmployee.getTitle());
    }
}