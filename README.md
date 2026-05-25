# Banking Backend API

Spring Boot backend for a simple banking API with users, accounts, transfers, transactions, PostgreSQL persistence, and Swagger/OpenAPI documentation.

## Tech Stack

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Spring Security
- PostgreSQL
- Maven Wrapper
- Springdoc OpenAPI / Swagger UI

## Requirements

- Java 21
- Docker, if you want to run PostgreSQL with `compose.yaml`
- No local Maven installation is required because the project includes `mvnw`

## Configuration

The application reads its database settings from `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bankingdb
spring.datasource.username=postgres
spring.datasource.password=DEIN_PASSWORT
```

If you use `compose.yaml`, make sure the values match your application configuration. The current compose file creates a database with:

```yaml
POSTGRES_DB=mydatabase
POSTGRES_USER=myuser
POSTGRES_PASSWORD=secret
```

Either update `application.properties` to match Docker, or update `compose.yaml` to match the application.

## Run Locally

Start PostgreSQL:

```bash
docker compose up -d
```

Run the application:

```bash
./mvnw spring-boot:run
```

The API starts on:

```text
http://localhost:8080
```

Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

## Build and Test

Run tests:

```bash
./mvnw test
```

Build the JAR:

```bash
./mvnw clean package
```

Run the built application:

```bash
java -jar target/BankingBackendAPI-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### Users

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/users` | List all users |
| `POST` | `/users` | Create a user |
| `DELETE` | `/users` | Delete a user from the request body |

### Accounts

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/accounts` | List all accounts |
| `POST` | `/accounts` | Create an account |
| `DELETE` | `/accounts/{id}` | Delete an account by ID |

### Transfers

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/transfers` | List all transactions |
| `POST` | `/transfers` | Transfer money between two accounts |

Example transfer request:

```json
{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 50.00,
  "description": "Rent payment"
}
```

## Project Structure

```text
src/main/java/org/example/bankingbackendapi
├── controller
├── dto
├── exception
├── model
├── repository
├── security
└── service
```

## Notes

- Hibernate is currently configured with `spring.jpa.hibernate.ddl-auto=update`, so tables are updated automatically during development.
- Security currently permits all requests except for the configured public matchers; review `SecurityConfig` before using this outside local development.
