# base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

