# Exercise 1: Spring Boot Application with Docker

## Functionalities
| Feature               | Description                                          | Endpoint      |
|-----------------------|------------------------------------------------------|---------------|
| **Palindrome Check**  | Checks if a word is a palindrome.                    | `/palindrome` |
| **Even Number Check** | Determines if a number is even/odd.                  | `/even`       |
| **Square Check**      | Verifies if B is the square of A.                    | `/square`     |
| **Calculator**        | Performs arithmetic operations (`+`, `-`, `*`, `/`). | `/calculator` |

---

## Implementation
### Code Structure
- **Controllers**: Handle HTTP requests (e.g., `PalindromeController`).
- **Services**: Business logic (e.g., `CalculatorService` for math operations).
- **Models**: Validate form inputs (e.g., `CalculatorForm` with `@NotNull` checks).
- **Templates**: Thymeleaf HTML pages for user interaction.

### Key Technologies
- Spring Boot 3
- Thymeleaf
- JUnit 5 / MockMvc
- Docker

---

## Tests
| Layer          | Tests Coverage                   | Example Test Case               |
|----------------|----------------------------------|---------------------------------|
| **Service**    | Unit tests for business logic.   | `PalindromeServiceTest`         |
| **Controller** | Integration tests for endpoints. | `CalculatorControllerTest`      |
| **Validation** | Form input validation.           | `@NotBlank` in `EvenNumberForm` |

---

## Repositories
- **GitHub**: [https://github.com/JMGanzar/Hands-on-classes-1](https://github.com/JMGanzar/Hands-on-classes-1)
- **Docker Hub**: [https://hub.docker.com/r/jmganzar/spring-boot-demoapp](https://hub.docker.com/r/jmganzar/spring-boot-demoapp)

---

## Docker Setup
### Dockerfile
```dockerfile
FROM openjdk:17-jdk-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### Docker Commands
**Descargar la imagen** desde Docker Hub (tag `final`):
```
docker pull jmganzar/spring-boot-demoapp:final
```
**Ejecutar el contenedor** (exponiendo el puerto 8080 de Spring Boot):
```
docker run -d -p 8080:8080 --name spring-app jmganzar/spring-boot-demoapp:final
```