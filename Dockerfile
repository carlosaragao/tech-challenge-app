# Use OpenJDK 17 as base image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/techfood-0.0.1-SNAPSHOT.jar /app/techfood-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "techfood-0.0.1-SNAPSHOT.jar"]
