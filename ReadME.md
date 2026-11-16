# Employee Management REST API

A RESTful web service developed using Java and Spring Boot as part of the HPE Software Engineering Job Simulation. The project demonstrates backend API development, employee data management, and automated testing.

## Overview

The application allows users to retrieve employee records and add new employees through HTTP GET and POST requests. Employee information is exchanged in JSON format and stored in an in-memory list.

Each employee record contains an employee ID, first name, last name, email, and job title.

## Tech Stack

- **Backend:** Java 17, Spring Boot
- **Build Tool:** Maven
- **Testing:** JUnit 5, Mockito, MockMvc
- **API Testing:** Postman

## Project Components

- **Employee.java:** Defines the employee data model with fields, constructors, getters, and setters.
- **Employees.java:** Maintains the list of employee records.
- **EmployeeManager.java:** Initializes sample employees and manages additions to the list.
- **EmployeeController.java:** Handles HTTP GET and POST requests.
- **RestServiceApplication.java:** Starts the Spring Boot application.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/employees` | Retrieves all employees in JSON format |
| POST | `/employees` | Adds a new employee from a JSON request |

**Example POST Request**

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

Clone the repository and navigate to the project directory:

```bash
cd cloud-resource-api
```

Start the application:

```bash
./mvnw spring-boot:run
```

On Windows PowerShell, use `.\mvnw.cmd spring-boot:run`.

The API will be available at `http://localhost:8080/employees`.

## Testing

The project includes six automated tests using JUnit 5, Mockito, and MockMvc, covering employee retrieval, employee creation, JSON responses, and HTTP status codes.

Run the tests using:

```bash
./mvnw clean test
```

The endpoints were also tested manually using Postman.

## Important Memory Detail

This project uses in-memory storage, so newly added employees are not retained after the application restarts. It was completed as an educational job simulation and does not interact with HPE production systems.
