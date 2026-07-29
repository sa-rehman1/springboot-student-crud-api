# Student CRUD API

## Overview

Student CRUD API is a RESTful web service developed using Spring Boot and Spring Data JPA. The application provides endpoints to create, retrieve, update, and delete student records stored in a MySQL database.

The project also demonstrates the implementation of both hard delete and soft delete functionality using Spring Data JPA derived query methods.

---

## Features

- Create a new student
- Retrieve a student by ID
- Retrieve all active students
- Update student information
- Hard delete a student
- Soft delete a student
- Layered architecture (Controller, Service, Repository)
- Constructor-based Dependency Injection
- Spring Data JPA
- MySQL database integration

---

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

---

## Project Structure

```
src
 ├── controller
 ├── entity
 ├── repository
 ├── service
 └── CrudarmyApplication
```

---

## API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /api/students/create | Create a student |
| GET | /api/students/get/{id} | Get student by ID |
| GET | /api/students/getall | Get all active students |
| PUT | /api/students/update/{id} | Update student |
| DELETE | /api/students/delete/{id} | Hard delete student |
| PATCH | /api/students/delete-soft/{id} | Soft delete student |

---

## Sample Request

```json
{
    "name": "Abdul",
    "age": 22,
    "email": "abdul@gmail.com",
    "rollNo": 101,
    "subject": "AI"
}
```

---

## Database

MySQL is used as the relational database.

The Student entity contains the following fields:

- id
- name
- age
- email
- rollNo
- subject
- deleted

The `deleted` field is used to support soft delete functionality.

---

## Running the Project

1. Clone the repository.

```
git clone https://github.com/your-username/springboot-student-crud-api.git
```

2. Configure MySQL.

Update `application.properties` with your database credentials.

3. Run the application.

4. Access the API at

```
http://localhost:8081
```

---

## Future Improvements

- Request validation using Bean Validation
- Global exception handling
- DTO implementation
- Pagination and sorting
- Unit and integration testing
- Swagger/OpenAPI documentation

---

## Author

Abdul Rehman
