# Start from a lightweight Java runtime image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the JAR
COPY currency-converter-app/target/currency-converter-app-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
