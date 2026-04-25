# Final Project

This project is about Java selenium with frameworks like TestNG, Cucumber.

## Overview

A comprehensive test automation framework built with Java, Selenium, TestNG, and Cucumber (BDD). This project combines powerful testing tools to create robust, maintainable, and scalable automation tests.

## Tech Stack

- **Java** (20.6%) - Core programming language
- **Selenium** - Web automation framework
- **TestNG** - Testing framework
- **Cucumber** (0.7%) - Behavior-Driven Development (BDD)
- **JavaScript** (34.4%) - Frontend/scripting
- **HTML** (18.7%) - Markup
- **Shell** (13.4%) - Scripts
- **CSS** (7.7%) - Styling
- **Batchfile** (4.5%) - Windows batch scripts

## Features

- Automated browser testing with Selenium WebDriver
- TestNG framework for test execution and reporting
- Cucumber for BDD test scenarios
- Cross-browser testing support
- Comprehensive test reports

## Prerequisites

- Java JDK 8 or higher
- Maven or Gradle (for dependency management)
- Selenium WebDriver
- TestNG
- Cucumber
- A web browser (Chrome, Firefox, Edge, Safari)

## Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Prasannakumar-27/Final_Project.git
   cd Final_Project
   ```

2. **Install dependencies**
   ```bash
   mvn install
   ```
   Or if using Gradle:
   ```bash
   gradle build
   ```

## Usage

### Running TestNG Tests
```bash
mvn test
```

### Running Cucumber Tests
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Running Specific Test Suite
```bash
mvn test -Dtest=TestClassName
```

## Project Structure

```
Final_Project/
├── src/
│   ├── main/
│   │   └── java/
│   ├── test/
│   │   ├── java/
│   │   └── resources/
│   │       └── features/
├── pom.xml
└── README.md
```

## Configuration

Update browser drivers and test configurations in the test resource files:
- `src/test/resources/config.properties` - Configuration settings
- `src/test/resources/features/` - Cucumber feature files

## Writing Tests

### Cucumber Feature Example
```gherkin
Feature: User Login
  Scenario: Valid user login
    Given User navigates to login page
    When User enters valid credentials
    Then User should see dashboard
```

## Running Tests

```bash
# Run all tests
mvn test

# Run specific feature
mvn test -Dcucumber.filter.tags="@regression"

# Run with TestNG
mvn test -Dsuite=testng.xml
```

## Reports

Test execution reports are generated in:
- `target/surefire-reports/` - TestNG reports
- `target/cucumber-reports/` - Cucumber reports

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For issues, questions, or suggestions, please create an issue in the repository.

## Author

[Prasannakumar-27](https://github.com/Prasannakumar-27)
