# FROM ubuntu:latest
# LABEL authors="Kenny"

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

EXPOSE 8080

CMD ["./gradlew", "runServer"]