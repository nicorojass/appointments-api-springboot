# Appointment Management API 🗓️

###### REST API built with Java and Spring Boot for managing users and appointments.

### Features ⚙️

#### User Management

- Create user (POST /api/users)
- Get user by ID (GET /api/users/{id})
- Get all users (GET /api/users)

#### Appointment Management

- Create appointment (POST /api/appointments)
- Get appointment by ID (GET /api/appointments/{id})
- Get all appointments (GET /api/appointments)
- Cancel appointment (PUT /api/appointments/{id}/cancel)

### Tech Stack 🧰

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

### Architecture

- Controller → Service → Repository → Database
- Entities relationship:
User (1) ──── (*) Appointment

### Setup

#### Requirements

- Java 17 or higher
- MySQL
- Maven

#### Steps

- Clone repository
```bash
git clone https://github.com/nicorojass/appointments-api-springboot.git
```

- Configure database in application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_appointments_managment_app
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```


- Run project
```bash
mvn spring-boot:run
```

#### API Examples

#### User
- Create User
POST /api/users

```json
{
  "name": "Nico",
  "lastName": "Test",
  "dni": 12345678,
  "email": "nico@test.com",
  "phoneNumber": "2230000000"
}
```

- Get User by ID
GET /api/users/1

- Get All Users
GET /api/users

#### Appointment
- Create Appointment
POST /api/appointments

```json
{
  "date": "2026-02-26",
  "time": "14:00",
  "status": "ACTIVE",
  "user": {
    "id": 1
  }
}
```

- Get Appointment by ID
GET /api/appointments/1

- Get All Appointments
GET /api/appointments

- Cancel Appointment
PUT /api/appointments/1/cancel

### Project Status ✅
#### Core backend completed.

#### Implemented:

- User management module
- Appointment management module
- Entity relationships
- RESTful endpoints
- MySQL persistence

#### Planned improvements:

- Global exception handling
- Pagination
- Validation rules (overlapping appointments)
- Automated tests

### Author 👨‍💻

#### Nicolás Rojas | Backend Developer – Java & Spring Boot

##### LinkedIn: https://linkedin.com/in/nicorojass
##### GitHub: https://github.com/nicorojass
