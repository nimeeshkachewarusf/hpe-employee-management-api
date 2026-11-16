# Employee Management REST API

A simple REST API built with Java and Spring Boot as part of the HPE Software Engineering Job Simulation. The project focuses on building a web service that can manage employee information through HTTP requests, along with automated testing to verify its functionality.

## Overview

The application allows users to retrieve a list of employees and add new employees by sending JSON data. It uses an in-memory list to store employee records, so no external database is required.

Each employee record contains an employee ID, first name, last name, email, and job title.

## Technologies Used

- Java 17
- Spring Boot
- Maven
- JUnit 5
- Mockito and MockMvc
- Postman

## Project Components

- **Employee.java** – Defines the employee data model, including fields, constructors, getters, and setters.
- **Employees.java** – Maintains the collection of employee records.
- **EmployeeManager.java** – Initializes sample employees and handles adding new employees.
- **EmployeeController.java** – Handles incoming HTTP requests and exposes the REST endpoints.
- **RestServiceApplication.java** – Main entry point for the Spring Boot application.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/employees` | Retrieves all employees as JSON |
| POST | `/employees` | Adds a new employee using JSON data |

Example POST request:

```json
{
  "employee_id": "EMP005",
  "first_name": "Alex",
  "last_name": "Wilson",
  "email": "alex@example.com",
  "title": "Software Engineer"
}
```

## Running the Application

From the project directory, run:

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080/employees`.

## Testing

The project includes automated tests using JUnit 5, Mockito, and MockMvc to verify employee retrieval, employee creation, and correct HTTP responses.

Run the tests using:

```bash
./mvnw clean test
```

The endpoints were also tested manually using Postman.

## Memory Important Detail

Employee data is stored in memory and resets whenever the application restarts. This project was developed as a learning exercise and does not connect to HPE's production systems.
