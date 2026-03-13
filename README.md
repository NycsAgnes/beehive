# Beehive

A Spring Boot application for managing beehives and their bee populations. This system allows you to create hives, add bees (Queens, Drones, Workers), and manage their assignments based on specific colony rules.

## Features

- **Hive Management**: Create and manage beehives with specific capacities.
- **Bee Management**: Register individual bees with names, birthdates, and types.
- **Colony Rules Enforcement**: The application enforces specific rules for hive composition:
    -   Each hive can have only **one Queen**.
    -   Drones and Workers can only be added to a hive that **already has a Queen**.
    -   Maximum of **2 Drones** per hive.
    -   Workers fill the remaining capacity (Total Capacity - 3).
- **Web Interface**: User-friendly Thymeleaf-based UI for managing the apiary.
- **REST API**: Exposes JSON endpoints for programmatic access to bee and hive data.

## Technologies Used

-   **Java 17**
-   **Spring Boot** (with Spring Web, Spring Data JPA, Validation)
-   **Thymeleaf** (Frontend templating engine)
-   **MySQL** (Database)
-   **H2 Database** (For testing support)
-   **Lombok** (For reducing boilerplate code)
-   **ModelMapper** (For Entity-DTO mapping)
-   **Maven** (Build tool)

## Prerequisites

-   Java 17 or higher
-   Maven (or use the included `mvnw` wrapper)
-   MySQL Database server (running on `localhost:3306`)

## Configuration

The application is configured to connect to a MySQL database named `beehive`.
Ensure your MySQL server is running and update the `src/main/resources/application.yaml` file with your database credentials if they differ from the defaults:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/beehive?createDatabaseIfNotExist=true...
    username: root        # Default: root
    password: test1234    # Default: test1234
```

## Running the Application

1.  **Navigate to the project directory**.
2.  **Run with Maven Wrapper**:
    
    On Windows:
    ```powershell
    .\mvnw.cmd spring-boot:run
    ```
    
    On macOS/Linux:
    ```bash
    ./mvnw spring-boot:run
    ```

3.  The application will start on port `8080`.

## Accessing the Application

Once the application is running, you can access the web interface:

-   **Manage Hives**: [http://localhost:8080/web/hives](http://localhost:8080/web/hives)  
    *(View, Create, and Details of Hives)*
-   **Manage Bees**: [http://localhost:8080/web/bees](http://localhost:8080/web/bees)  
    *(View, Register, and Details of Bees)*

### API Endpoints

The application also provides a REST API:

-   `GET /api/hives` - Retrieve all hives
-   `POST /api/hives` - Create a new hive
-   `GET /api/hives/{id}` - Get hive details
-   `GET /api/bees` - Retrieve all bees
-   `POST /api/bees` - Register a new bee

## Project Structure

-   `src/main/java/com/nycsagnes/beehive` - Application Source Code
    -   `controller` - Handles Web (Thymeleaf) and REST requests
    -   `domain` - JPA Entities (`Bee`, `Hive`, `BeeType`)
    -   `dto` - Data Transfer Objects for API communication
    -   `service` - Business logic (including hive capacity rules)
    -   `repository` - Spring Data JPA Repositories
-   `src/main/resources`
    -   `templates` - HTML templates for the UI
    -   `static` - Static assets (CSS, Images)
    -   `application.yaml` - Application configuration

