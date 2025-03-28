FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY ../Backend .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/Backend-0.0.1-SNAPSHOT.jar EvalTest.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "EvalTest.jar"]
