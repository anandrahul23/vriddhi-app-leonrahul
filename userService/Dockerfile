# Use a lightweight base image with Zulu OpenJDK 19
FROM azul/zulu-openjdk-alpine:23

# Copy the WAR file to the working directory
COPY ./build/libs/userService-0.0.4-SNAPSHOT.jar /app/userService-0.0.4-SNAPSHOT.jar

# Set the working directory
WORKDIR /app

# Expose the required ports
EXPOSE 8080-8090

# Run the application
CMD ["sh", "-c", "java -jar -Dspring.profiles.active=dev /app/userService-0.0.4-SNAPSHOT.jar"]
