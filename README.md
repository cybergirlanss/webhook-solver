# Webhook Solver - Spring Boot Application

A Spring Boot application that automatically generates webhooks, solves SQL problems based on registration number parity, and submits solutions with JWT authentication. Built for the Bajaj Finserv Health hiring process.

## 🚀 Features

- **Automatic Execution**: Runs automatically on application startup
- **REST API Integration**: Communicates with external webhook APIs
- **JWT Authentication**: Handles JWT tokens for secure API calls
- **SQL Problem Solving**: Solves SQL problems based on registration number logic
- **RestTemplate**: Uses Spring's RestTemplate for HTTP communications

## 📋 Problem Statement

**"Find the highest salary that was credited to an employee, but only for transactions that were not made on the 1st day of any month. Along with the salary, extract employee name (combined first and last name), age, and department name."**

## 🛠️ Technology Stack

- **Java 21**
- **Spring Boot 3.2.0**
- **Maven** (Build tool)
- **RestTemplate** (HTTP client)
- **JWT** (Authentication)

## 📁 Project Structure
webhook-solver/
├── src/main/java/com/example/webhooksolver/
│   ├── WebhookSolverApplication.java     # Main application class
│   ├── config/
│   │   └── AppConfig.java                # RestTemplate configuration
│   ├── dto/                              # Data transfer objects
│   │   ├── GenerateWebhookRequest.java
│   │   ├── GenerateWebhookResponse.java
│   │   └── SolutionResponse.java
│   └── service/                          # Business logic
│       ├── WebhookService.java
│       └── SqlProblemSolver.java
├── src/main/resources/
│   └── application.properties            # Application configuration
├── target/
│   └── webhook-solver.jar                # Compiled JAR file (19.6 MB)
├── pom.xml                               # Maven configuration
└── README.md                             # Project documentation


### File Details:
- **WebhookSolverApplication.java**: Main entry point, starts Spring Boot application
- **AppConfig.java**: Configures RestTemplate bean for HTTP requests
- **GenerateWebhookRequest.java**: DTO for initial API request payload
- **GenerateWebhookResponse.java**: DTO for webhook API response
- **SolutionResponse.java**: DTO for final solution submission
- **WebhookService.java**: Main service handling the entire workflow
- **SqlProblemSolver.java**: Service that generates the SQL query based on reg number
- **application.properties**: Configuration settings and API URLs
- **webhook-solver.jar**: Executable JAR file (Spring Boot fat jar)
- **pom.xml**: Maven dependencies and build configuration


## 🏃‍♂️ How to Run

### Prerequisites
- Java 21 or higher
- Maven 3.6+ 

### Build and Run
```bash
# Clone the repository
git clone https://github.com/cybergirlanss/webhook-solver.git

# Navigate to project directory
cd webhook-solver

# Build the project
mvn clean package

# Run the application
java -jar target/webhook-solver.jar

## 📝 API Endpoints

The application makes these API calls automatically:

### 1. Generate Webhook
```http
POST https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA
Content-Type: application/json

{
  "name": "Ansu M George",
  "regNo": "xyzzz", 
  "email": "your.email@example.com"
}

## 👨‍💻 Developer

**Name:** Ansu M George  

## 📄 License

This project is created for educational purposes as part of the Bajaj Finserv Health hiring process.
