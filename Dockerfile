# -------- Build Stage --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy everything and build the app
COPY . .
RUN mvn clean package -DskipTests

# -------- Run Stage --------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port Spring Boot uses
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
