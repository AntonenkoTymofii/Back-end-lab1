FROM maven:3.8.6-eclipse-temurin-17 as builder
WORKDIR lab1/app
COPY mvnw pom.xml ./
COPY ./src ./src
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR lab1/app
EXPOSE 8080
COPY --from=builder /lab1/app/target/*.jar /lab1/app/*.jar
ENTRYPOINT ["java", "-jar", "/lab1/app/*.jar"]