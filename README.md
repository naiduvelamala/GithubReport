# GitHub Access Report

## Overview

GitHub Access Report is a Spring Boot REST API that integrates with the GitHub REST API to generate a user-to-repository access report for a GitHub organization.

The application authenticates using a GitHub Personal Access Token (PAT), retrieves repositories and collaborators from the specified organization, and exposes a REST endpoint that returns a structured access report.

---

## Features

- Authenticate with GitHub using Personal Access Token (PAT)
- Retrieve all repositories from a GitHub organization
- Retrieve collaborators for each repository
- Generate a User → Repository access report
- Expose REST API using Spring Boot
- JSON response format

---

## Technologies Used

- Java 21
- Spring Boot
- Spring Web
- RestClient
- Maven
- GitHub REST API
- Git

---

## Project Structure

```
src
├── config
├── controller
├── service
├── client
└── dto
```

---

## API Endpoint

### Generate Access Report

```
GET /access-report
```

### Sample Response

```json
{
  "naiduvelamala": {
    "repositories": [
      "backend",
      "frontend",
      "admin",
      "mobileapp"
    ]
  },
  "velamalanaidu2005": {
    "repositories": [
      "backend",
      "mobileapp"
    ]
  }
}
```

---

## Configuration

Update the following properties in `application.properties`:

```properties
github.token=YOUR_GITHUB_TOKEN
github.organization=YOUR_ORGANIZATION_NAME
```

---

## How to Run

1. Clone the repository

```
git clone https://github.com/naiduvelamala/GithubReport.git
```

2. Open the project in IntelliJ IDEA.

3. Configure your GitHub token in `application.properties`.

4. Run the Spring Boot application.

5. Access the API:

```
http://localhost:8080/access-report
```

---

## Future Improvements

- Global Exception Handling
- Parallel API Calls using CompletableFuture
- Unit Testing
- Logging
- Permission Level Reporting

---

## Author

**Naidu Velamala**

GitHub: https://github.com/naiduvelamala
