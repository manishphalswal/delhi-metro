# Use the official OpenJDK 11 image as the base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /delhi-metro

# Copy the JAR file into the container
COPY target/delhi-metro-2.5.6.jar delhi-metro.jar

# Expose the port your application is running on (if necessary)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "delhi-metro.jar"]