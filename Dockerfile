# Use OpenJDK 17 as base image
FROM openjdk:17

# Argument to specify the JAR file name
ARG JAR_FILE="techfood-0.0.1-SNAPSHOT.jar"

# Create a non-root user to run the application
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Switch to the non-root user
USER appuser:appgroup

# Set working directory
WORKDIR /app

# Copy the compiled JAR file into the container
#COPY target/${JAR_FILE} /app/${JAR_FILE}
ADD ./build/libs/${JAR_FILE} .

# Expose the port your application runs on
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "techfood-0.0.1-SNAPSHOT.jar"]
