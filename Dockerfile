# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-slim

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file and fetch dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src

# Package the application (skipping tests for faster build)
RUN mvn package -DskipTests

# Debug step: list contents of the target directory
RUN ls -l target/

# Copy the jar file to the container
COPY target/sneakerdrop-alert-service-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
