# Use an official OpenJDK image as the base image
FROM eclipse-temurin:17

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
# Replace 'your-application.jar' with the actual name of your JAR file
COPY build/libs/SimpleApplication-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application listens on (e.g., 8080)
EXPOSE 8080

# Set the entry point for the container to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
