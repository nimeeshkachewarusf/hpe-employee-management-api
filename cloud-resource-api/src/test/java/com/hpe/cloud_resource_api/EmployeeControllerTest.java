package com.hpe.cloud_resource_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeManager employeeManager;

    // Test 1: GET returns all employees
    @Test
    void testGetAllEmployees() throws Exception {

        Employee employee1 = new Employee(
                "EMP001", "John", "Smith",
                "john@example.com", "Developer");

        Employee employee2 = new Employee(
                "EMP002", "Sarah", "Johnson",
                "sarah@example.com", "Manager");

        Employees employees = new Employees(
                List.of(employee1, employee2));

        when(employeeManager.getEmployees())
                .thenReturn(employees);

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Employees.length()")
                        .value(2))
                .andExpect(jsonPath(
                        "$.Employees[0].first_name")
                        .value("John"))
                .andExpect(jsonPath(
                        "$.Employees[1].employee_id")
                        .value("EMP002"));

        verify(employeeManager).getEmployees();
    }

    // Test 2: GET returns an empty list
    @Test
    void testGetEmptyEmployees() throws Exception {

        when(employeeManager.getEmployees())
                .thenReturn(new Employees(List.of()));

        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Employees.length()")
                        .value(0));
    }

    // Test 3: POST creates a new employee
    @Test
    void testAddEmployee() throws Exception {

        Employee newEmployee = new Employee(
                "EMP005", "Alex", "Wilson",
                "alex@example.com", "Engineer");

        when(employeeManager.addEmployee(
                any(Employee.class)))
                .thenReturn(newEmployee);

        String json = """
                {
                    "employee_id": "EMP005",
                    "first_name": "Alex",
                    "last_name": "Wilson",
                    "email": "alex@example.com",
                    "title": "Engineer"
                }
                """;

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.employee_id")
                        .value("EMP005"))
                .andExpect(jsonPath("$.first_name")
                        .value("Alex"))
                .andExpect(jsonPath("$.title")
                        .value("Engineer"));

        verify(employeeManager).addEmployee(
                any(Employee.class));
    }
}