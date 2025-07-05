# Use official OpenJDK 17 image
FROM openjdk:24-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the JAR file from your local target folder into the container
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
