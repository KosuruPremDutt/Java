# Use an official OpenJDK 17 runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Set a working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/doctor-appointment-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
