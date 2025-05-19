# Use a lightweight Java 17 JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Create a directory for extensions (SPI + implementations)
RUN mkdir -p /app/extensions

# Copy the main application JAR
COPY currency-converter-app/target/currency-converter-app-*.jar app.jar

# Copy SPI and implementation JARs to the extensions folder
COPY currency-converter-spi/target/currency-converter-spi-*.jar /app/extensions/
COPY usd-to-eur-impl/target/usd-to-eur-impl-*.jar /app/extensions/
COPY usd-to-sek-impl/target/usd-to-sek-impl-*.jar /app/extensions/

# Launch the application using classpath with all modules
ENTRYPOINT ["java", "-cp", "app.jar:extensions/*", "converter.app.ConverterApplication"]
