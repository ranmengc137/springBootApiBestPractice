# Spring Boot API Best Practices

A starter project demonstrating **clean Controller layer design** in Spring Boot, featuring:

- ✅ Unified API response structure (`Result<T>`)
- ✅ Centralized exception handling with `@RestControllerAdvice`
- ✅ Automatic parameter validation using JSR-303 annotations
- ✅ Response wrapping via `ResponseBodyAdvice`
- ✅ Decoupled Service layer and DTOs

This repository is intended as a **best-practices template** for building maintainable Spring Boot REST APIs.

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+

### Run locally
```bash
mvn spring-boot:run
```
The app will start at `http://localhost:8080`

---

## 📖 Example Usage

### Test Endpoint
**Request**
```http
POST /test
Content-Type: application/json

{
  "num": 5,
  "type": "square"
}
```

**Response**
```json
{
  "code": 2001,
  "message": "API call successful",
  "data": 25.0
}
```

### Validation Example
**Request**
```http
POST /pretty/test-validation
Content-Type: application/json

{
  "userName": "",
  "password": "123",
  "email": "not-an-email"
}
```

**Response**
```json
{
  "code": 2002,
  "message": "Validation failed: userName: must not be blank, password: length must be between 6 and 20, email: must be a well-formed email address, ",
  "data": null
}
```

---

## 🏗️ Project Structure

```text
com.example.demo
├── advice          # ResponseBodyAdvice & ExceptionAdvice
├── common          # Result, ResultEnum, IResult
├── controller      # REST controllers
├── dto             # Data Transfer Objects
├── exception       # Custom exceptions
└── service         # Service layer
```

---

## 🧰 Tech Stack

- Spring Boot 3.x
- Spring Validation (Jakarta Validation / Hibernate Validator)
- Lombok
- Jackson (JSON serialization)

---

## ✅ Next Steps / Improvements

- Add Swagger/OpenAPI (`springdoc-openapi`) for automatic docs
- Add unit tests (`@WebMvcTest`) for Controllers & ExceptionAdvice
- Add GitHub Actions CI (build + test)
- Add Dockerfile for containerized deployment

---

## 📜 License

MIT License

