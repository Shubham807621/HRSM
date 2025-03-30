FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean install

CMD ["java", "-jar", "target/your-app.jar"]
