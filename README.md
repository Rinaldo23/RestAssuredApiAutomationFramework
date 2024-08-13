---

# REST Assured API Automation Framework

## Overview

The REST Assured Automation Framework is a comprehensive tool for automating API testing using REST Assured, a popular Java library. This framework provides a clean and scalable structure that enables efficient API testing with reusable components, robust validation, and easy configuration management. The framework is designed to be extendable and easily maintainable, making it suitable for both small and large-scale API test automation projects.

## Features

- **Modular Design**: Organized using the Page Object Model (POM) for APIs, separating concerns and enhancing maintainability.
- **Configurable**: Centralized configuration management using properties files.
- **Reusable Utilities**: Helper classes for common tasks like JSON validation and response verification.
- **Schema Validation**: Supports JSON schema validation for ensuring API response structure.
- **Data Management**: Utilizes Java Faker for dynamic test data generation.

## Project Structure

```
REST-Assured-Automation-Framework/
├── src/
│   └── test/
│       └── java/
│       |   └── com/
│       |       └── qa/
│       |           ├── api/
│       |           │   ├── endpoints/
│       |           │       ├── Routes.java
│       |           │   │   └── UserEndPoints.java
│       |           │   ├── enums/
│       |           │   │   └── StatusCode.java
│       |           │   ├── payload/
│       |           │   │   └── User.java
│       |           │   └── utilities/
│       |           │       ├── HelperClass.java
│       |           │       └── SchemaPaths.java
│       |           │   └── tests/
│       |           │       ├── CreateUser.java
│       |           │       ├── DeleteUser.java
│       |           │       ├── FetchUser.java
│       |           │       └── UserTests.java
│       └── resources/
|           ├── Schema/
│               ├── CreateUser.json
│               ├── GetUser.json
│               ├── UpdateUser.json
│               └── LoginUser.json
│           └── XML/
│               ├── users.xml
│               ├── apichainingAtTestLevel.xml
│               └── apichainingAtSuiteLevel.xml
└── pom.xml
```

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Maven**: For dependency management and build automation.
- **REST Assured**: A Java library for testing RESTful web services.
- **TestNG**: A testing framework for running and managing tests.

### Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/REST-Assured-Automation-Framework.git
   cd REST-Assured-Automation-Framework
   ```

2. **Install Dependencies:**
   Ensure that Maven is installed, then run the following command:
   ```bash
   mvn clean install
   ```

### Running Tests

You can run the test suite using Maven or directly from your IDE:

- **Maven Command:**
  ```bash
  mvn test
  ```

- **Using an IDE:**
  - Right-click on the `UserTests.java` file or the test package and select "Run".

## Usage

### API Endpoints

The API endpoints are defined in the `Routes.java` class, which centralizes all the API routes used in the tests. This approach ensures that any change in the API paths only requires a single update in the `Routes` class.

### Test Cases

- **UserTests.java**: Contains tests for CRUD operations related to users, including creating, fetching, updating, and deleting a user, as well as login and logout functionalities.
- **Individual Test Classes**: For showcasing API chaining, individual files have been created for each CRUD operation, allowing for more granular control and better organization of tests. Each class focuses on a specific operation such as create, read, update, or delete, demonstrating how API requests can be chained in separate classes.

### Schema Validation

JSON schema files are stored in the `schemas` directory. The `HelperClass` provides a method for validating API responses against these schemas, ensuring that the structure of the responses is as expected.

### Status Codes

The `StatusCode` enum class defines expected HTTP status codes, making the code more readable and less error-prone by avoiding hard-coded values.

## Test Scenarios

1. **Create User**: Validates the creation of a new user and verifies the response schema.
2. **Fetch User**: Retrieves an existing user by username and validates the response structure.
3. **Update User**: Updates user details and confirms that the operation is successful.
4. **Delete User**: Deletes a user and ensures that the user no longer exists.
5. **Login User**: Validates user login and checks that the session is created.
6. **Logout User**: Logs out the user and verifies the operation.

## Extending the Framework

This framework can be extended by adding new endpoint classes, payload models, and utilities. The modular design allows for easy integration of additional test cases and functionalities.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure that your code adheres to the project's coding standards and includes relevant tests.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact

For any queries or issues, feel free to reach out at rinaldobadigar@gmail.com.

---
