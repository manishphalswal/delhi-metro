# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* This service helps in performing ticket bookings in Delhi metro
* Expose endpoint to calculate fare
* Helps to get route and station information

### Integrated features
* Can be deployed and run using docker-compose feature
* Swagger UI to try out the exposed rest apis or endpoints
* Default port 8080

### Swagger UI Details
The following link provides the detail of api endpoints and try them out feature:

http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

### Steps to build, deploy and run the application
* Pre-requisite
  - docker-compose tool should be installed
  - Minimum Java 11 and Maven should be installed
  
* Steps
  - Clone and Checkout the repository on local file system
  - Navigate to service's root folder i.e. /delhi-metro on CLI
  - Run following command to create jar in target folder: mvn clean install -DskipTests
  - Run docker compose command to deploy and run application: docker-compose up
  - Access the above swagger url or use any rest api client tool to hit the endpoints
    
    


