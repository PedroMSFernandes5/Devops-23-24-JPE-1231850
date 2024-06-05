# FROM ubuntu:latest
# LABEL authors="Kenny"

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/basic_demo-0.1.0.jar /app/basic_demo-0.1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "basic_demo-0.1.0.jar"]