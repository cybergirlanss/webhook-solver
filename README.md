# Webhook Solver - Spring Boot Application

A Spring Boot application that automatically generates webhooks, solves SQL problems based on registration number parity, and submits solutions with JWT authentication. Built for the Bajaj Finserv Health hiring process.

## 🚀 Features

- **Automatic Execution**: Runs automatically on application startup
- **REST API Integration**: Communicates with external webhook APIs
- **JWT Authentication**: Handles JWT tokens for secure API calls
- **SQL Problem Solving**: Solves SQL problems based on registration number logic
- **RestTemplate**: Uses Spring's RestTemplate for HTTP communications

## 📋 Problem Statement

For registration number `22bsa10229` (ends with 29 - odd), the application solves:

**"Find the highest salary that was credited to an employee, but only for transactions that were not made on the 1st day of any month. Along with the salary, extract employee name (combined first and last name), age, and department name."**

## 🛠️ Technology Stack

- **Java 21**
- **Spring Boot 3.2.0**
- **Maven** (Build tool)
- **RestTemplate** (HTTP client)
- **JWT** (Authentication)
