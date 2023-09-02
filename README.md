# CloudtalkAssignment

## Overview

Project include automated tests for Unix Timestamp Converter API.
 
Technology stack used:
 - Java 17
 - Rest Assured
 - JUnit

## Table of Contents

1. [Running Tests Locally](#running-tests-locally)
2. [Automated Test Cases](#automated-test-cases)
3. [Running Tests in GitHub Actions](#running-tests-in-github-actions)
4. [API Improvements](#api-improvements)

## Running Tests Locally

To run the automated tests for the Unix Timestamp Converter API locally, follow these steps:

### Prerequisites

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
### Setup

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/avalenkevych/CloudtalkAssignment.git
   cd your-repo
   ```

2. Install project dependencies using Gradle (or Maven):

   ```bash
   ./gradlew clean test
   ```

### Running Tests

3. Run the automated tests:


   ```bash
   ./gradlew test
   ```


4. View the test results in your terminal.

## Automated Test Cases

The automated tests cover various scenarios for the Unix Timestamp Converter API. These include:

- **Convert Unix Timestamp to Date String:** Test cases for converting Unix Timestamp to Date String, covering typical and edge cases.
- **Convert Date String to Unix Timestamp:** Test cases for converting Date String to Unix Timestamp, with scenarios like valid dates, invalid dates, and different formats.

Feel free to explore the test classes in the repository to see the detailed test cases.

## Running Tests in GitHub Actions

This project is set up to run automated tests using GitHub Actions whenever there is a push to the `main` branch. The workflow is defined in the `.github/workflows/test.yml` file.

### Viewing Workflow Runs

1. Visit the "Actions" tab in your GitHub repository to view the workflow runs.

2. Select the latest workflow run to see its details, including test results.

3. You can click on individual test runs to see detailed logs and any failed tests.

## API Improvements

### 1. Error Handling and Validation:

   - Provide informative error messages to users, helping them understand issues with their input.
   - Handle exceptional cases such as invalid date formats or out-of-range timestamps and return appropriate error codes.
   
### 2. API Documentation:

   - Create comprehensive API documentation that includes clear instructions on how to use the API, available endpoints, input formats, and expected responses.
   - Use tools like Swagger/OpenAPI to generate interactive API documentation for easy exploration. 

### 3. Monitoring and Logging:

   - Implement thorough logging to capture errors, warnings, and other relevant information for troubleshooting.
   - Set up monitoring tools to track API usage, performance metrics, and uptime.
---
