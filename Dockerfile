# Use a lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all project files into the container
COPY . .

# Ensure the Maven wrapper is executable & convert line endings
RUN chmod +x ./mvnw && apt-get update && apt-get install -y dos2unix && dos2unix ./mvnw

# Build the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (default Spring Boot port)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/*.jar"]
