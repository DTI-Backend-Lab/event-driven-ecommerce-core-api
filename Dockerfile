FROM maven:3.9.12-eclipse-temurin-17 AS build

WORKDIR /build
COPY . .
COPY pom.xml ./

RUN mvn clean package -DskipTests



FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /build/target/*.jar ./app/app.jar

EXPOSE 8080
ENV TZ='America/Sao_Paulo'
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
