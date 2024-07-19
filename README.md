# Spring Boot One-To-One Mapping

## Overview

This project demonstrates a simple Spring Boot application with a one-to-one relationship mapping between two entities using Hibernate and MySQL. The application showcases how to set up and manage one-to-one relationships in a Spring Boot environment.

## Technologies Used

- **Spring Boot**: Framework for building Java-based applications.
- **Hibernate**: ORM tool for mapping Java objects to database tables.
- **MySQL**: Relational database management system.
- **Maven**: Project management tool.

## Features

- One-to-one relationship mapping between `User` and `UserProfile`.
- CRUD operations for managing `User` and `UserProfile`.
- RESTful APIs for interacting with the entities.

## Getting Started

### Prerequisites

- JDK 1.8 or later
- MySQL Server
- Maven

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/Pranaydalvi/SpringBoot_OneToOne_Mapping.git
    ```

2. **Navigate to the Project Directory:**

    ```bash
    cd SpringBoot_OneToOne_Mapping
    ```

3. **Configure MySQL Database:**

    Update the `application.properties` file in `src/main/resources` with your MySQL database details:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

4. **Build the Project:**

    ```bash
    mvn clean install
    ```

5. **Run the Application:**

    ```bash
    mvn spring-boot:run
    ```

## Usage

The application exposes RESTful APIs for managing `User` and `UserProfile` entities. Here are some example endpoints:

- **Create User:**

    ```
    POST /users
    ```

- **Get User by ID:**

    ```
    GET /users/{id}
    ```

- **Update User:**

    ```
    PUT /users/{id}
    ```

- **Delete User:**

    ```
    DELETE /users/{id}
    ```

## Code Structure

- `src/main/java/com/example/demo`: Contains the main application code.
  - `controller`: REST controllers for handling HTTP requests.
  - `model`: Entity classes representing the database tables.
  - `repository`: Interfaces for CRUD operations.
  - `service`: Business logic and service classes.
- `src/main/resources`: Configuration files and application properties.




