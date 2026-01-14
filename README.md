Appointment Management API

REST API built with Java and Spring Boot for managing users and appointments.

Features

User Management

- Create user (POST /api/users)
- Get user by ID (GET /api/users/{id})
- Get all users (GET /api/users)

Appointment Management
In progress

Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

Architecture
- Controller → Service → Repository → Database

Setup

Requirements
- Java 17 or higher
- MySQL
- Maven

Steps

1. Clone repository
git clone https://github.com/tuusuario/appointments-api-springboot.git

2. Configure database in application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=your_user
spring.datasource.password=your_password

3. Run project
mvn spring-boot:run

API Example

- Create user
POST /api/users

{
"name": "Nico",
"lastName": "Prueba",
"dni": 12345678,
"email": "nico@test.com
",
"phoneNumber": "2230000000"
}

- Get user by id
GET /api/users/1

- Get all users
GET /api/users

Project Status

User management module completed.
Appointment management module under development.

Author

Nicolás Rojas
Backend Developer (Java & Spring Boot)

- LinkedIn: https://linkedin.com/in/nicolaserojas
- GitHub: https://github.com/nicorojass
