# 🔐Auth Service

Auth-service is the central stateless authentication microservice. It handles user registration, login, and JWT token generation. All authentication state is maintained via JWT tokens, with no session storage. Other services interact with this to authenticate and authorize users.

# 🧩 Responsibilities

- User registration and login.
- Authenticating user and generating JWT token.
- Password encryption using BCrypt
- Role-based authentication support

# 🏗️ Tech Stack
- Java 17
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- MySQL

# 🌀 System Role
```plaintext
┌────────────────────────────┐
│     other-service          │
└────────────┬───────────────┘
             │
  Authenticate/Register Users
             │
             ▼
     ┌────────────────────-┐
     │    auth-service     │
     │   (JWT Provider)    │
     └─────────┬───────────┘
               │
               ▼
      [ JWT Token Returned ]
 ```

# 📁 Package Overview

```plaintext
com.user.auth
│
├── controller        # `/api/v1/auth/register`, `/api/v1/auth/login`, and `/api/v1/auth/users` endpoints (accessible to Auth-service Admin only).
├── service           # jwt Token generation and user logic
├── config            # Security filters and password encoder
├── models            # JPA User entity
├── repository        # Spring Data JPA user repo
├── dto               # RegisterUserDTO, UserResponseDTO, etc.
└── exception         # Custom exceptions and handlers
```

# 📤 API Endpoints
#### 🔸 POST /api/v1/auth/register
- Registers a user and returns a JWT token.

REQUEST BODY:

```json
{
  "username": "user",
  "password": "password123",
  "role": "ADMIN"
}
```
RESPONSE:
```json

{
  "username": "user",
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```
#### 🔸 POST /api/v1/auth/login
- Authenticates a user extract claims and returns a JWT token.

REQUEST BODY:
```json
{
  "username": "user",
  "password": "password123"
}
```
RESPONSE:
```json
{
  "username": "user",
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```
# 🔐 JWT Security
- JWT secret is stored in environment variables and loaded into the application using application.properties.
- All tokens are stateless and signed.
- Role info is embedded in token claims.

# ⚙️ Configuration
```properties
# DB
spring.datasource.url=jdbc:mysql://localhost:3306/AuthService
spring.datasource.username=root
spring.datasource.password=your_password

# JWT Secret
jwt.secret=${JWT_SECRET} (make sure you have this JWT_SECRET set in you enviroment variable)
```
# 🧪 Testing the API
- Use postman/curl to:
#### 🔐 Register User
```bash
curl -X POST http://localhost:8081/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username": "user", "password": "password123", "role": "ADMIN"}'
  ```

#### 🔐 Login (Get JWT Token)
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user",
    "password": "password"
}'
```
# 🔄 Token Validation (by other services)
- Other services use the shared secret to decode and validate tokens.
- No /validate endpoint required to avoid coupling.
- Multiple stateless services can validate tokens independently.

# 🚀 Running Locally
```bash
git clone https://github.com/nd-09/AuthService.git
cd auth-service

# Before running, make sure to:
# 1. Create the MySQL database `Aust-service`
# 2. Set environment variable `JWT_SECRET` with your secret key

./mvnw spring-boot:run
```
# 🛠️ Future Scope
- Refresh token support
- Email verification flow
- Forgot password / reset password endpoints

# 👨‍💻 Author
Created with ❤️ by Navdeep Chovatiya.
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?logo=linkedin)](https://www.linkedin.com/in/navdeep-chovatiya-73349222a)

