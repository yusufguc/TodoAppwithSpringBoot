📌 Spring Boot ToDo API

A clean and production-ready RESTful ToDo API built with Spring Boot 3, featuring JWT authentication (Access + Refresh Tokens), custom exception handling, pagination, sorting, and PostgreSQL database integration.
Swagger UI is included for easy API testing.


🚀 Features
-------------------------------------
🔐 Authentication & Authorization
User Registration & Login
Secure password hashing (BCrypt)
JWT Access Token
JWT Refresh Token
Spring Security Filter Chain integration
Custom Unauthorized (401) & Forbidden (403) responses


📝 To-Do Management
Create, Update, Delete To-Do items
Get all items with pagination + sorting
DTO layer included

⚙️ Infrastructure
PostgreSQL with Hibernate/JPA
Custom exception handler
Global error messages
Swagger UI (OpenAPI 3)
Lombok support
Service + Repository architecture


🛠 Tech Stack
| Layer      | Technology                        |
| ---------- | --------------------------------- |
| Backend    | Spring Boot 3.3.4                 |
| Language   | Java 17                           |
| Security   | Spring Security 6 + JWT           |
| Database   | PostgreSQL                        |
| API Docs   | Swagger (springdoc-openapi 2.3.0) |
| ORM        | Hibernate / JPA                   |
| Build Tool | Maven                             |

📦 Installation
1. Clone the repository
git clone https://github.com/yourusername/Spring-Boot-ToDo-API.git
   
3. Configure your PostgreSQL
Create a database:
CREATE DATABASE todoapi;

4. Update application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todoapi
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect



🧱 Project Structure
src/main/java/com/ysfgc
│
├── config
├── controller
│   └── impl
├── dto
├── exception
├── handler
├── jwt
├── model
├── repository
├── service
│   └── impl
└── SpringBootApplication


Feel free to fork this repository and submit pull requests.
Suggestions and improvements are always welcome.










