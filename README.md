# SmartCampus Connect

## BITP3123 Distributed Systems Group Project

SmartCampus Connect is a distributed campus management system developed for the BITP3123 Distributed Systems course. The project demonstrates Service-Oriented Architecture (SOA), RESTful web services, SOAP web services, asynchronous messaging, and distributed system concepts.

---

## Project Overview

The system consists of multiple independent services that communicate through REST APIs, SOAP Web Services, and TCP Socket messaging.

Implemented services:

* Student Service
* Enrolment Service
* Notification Service
* Library SOAP Service

---

## Technologies Used

* Java 17
* Spring Boot 3
* Spring Web
* Spring Web Services (SOAP)
* MySQL
* Maven
* Postman

---

## Project Structure

```text
SmartCampusConnect
│
├── student-service
├── enrolment-service
├── notification-service
├── library-soap-service
└── README.md
```

---

## Databases

Create the following MySQL databases before running the project.

```sql
CREATE DATABASE student_db;
CREATE DATABASE enrolment_db;
```

The Notification Service and Library SOAP Service do not require separate databases in this implementation.

---

## Build

Open a terminal in each service folder and execute:

```bash
mvn clean install
```

---

## Running the System

Start the services in the following order.

### 1. Student Service

```bash
cd student-service
mvn spring-boot:run
```

Runs on:

```
http://localhost:8081
```

---

### 2. Notification Service

```bash
cd notification-service
java -cp target/classes com.smartcampus.NotificationServer
```

Runs on:

```
Port 5000
```

---

### 3. Enrolment Service

```bash
cd enrolment-service
mvn spring-boot:run
```

Runs on:

```
http://localhost:8082
```

---

### 4. Library SOAP Service

```bash
cd library-soap-service
mvn spring-boot:run
```

Runs on:

```
http://localhost:8083
```

WSDL:

```
http://localhost:8083/ws/library.wsdl
```

---

## REST Endpoints

### Student Service

GET

```
/students
```

POST

```
/students
```

---

### Enrolment Service

POST

```
/enrolments
```

GET

```
/enrolments
```

---

## SOAP Operation

Operation:

```
borrowBook()
```

SOAP Endpoint

```
http://localhost:8083/ws
```

---

## Features

* RESTful APIs
* SOAP Web Service
* WSDL generation
* SOAP Fault handling
* TCP Socket Notification
* Producer–Consumer Messaging
* Thread Pool using ExecutorService
* Multi-tier Client-Server Architecture
* Service-Oriented Architecture (SOA)

---

## Build Command

Each service can be built using:

```bash
mvn clean install
```

---

## Team SixSeven

BITP3123 Distributed Systems

SmartCampus Connect Project
