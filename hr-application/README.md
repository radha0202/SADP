# HR Application (Spring Boot)

## Run
- Build: `mvn clean package`
- Run: `mvn spring-boot:run` or run the main class `com.example.hr.HrApplication`

## APIs (base: http://localhost:8080/api/employees)
- POST /api/employees     -> create employee (json body)
- GET  /api/employees     -> list all
- GET  /api/employees/{id} -> get by id
- PUT  /api/employees/{id} -> update
- DELETE /api/employees/{id} -> delete

H2 console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:hrdb
