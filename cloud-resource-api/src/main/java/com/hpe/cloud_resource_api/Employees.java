package com.hpe.cloud_resource_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Employees {

    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    @JsonProperty("Employees")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}