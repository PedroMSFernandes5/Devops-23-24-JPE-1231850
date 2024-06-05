# CA4 Part 1: Containers with Docker

## Overview

This part of the assignment focuses on practicing with Docker by creating Docker images and running containers using a chat application from CA2. The goal is to package and execute the chat server in a Docker container.

## Requirements

- Create a Docker image to execute the chat server.
- Publish the Docker image on Docker Hub.
- Execute the chat client on your host computer and connect to the chat server running in the container.
- Create two versions of the Docker solution:
    - Version 1: Build the chat server inside the Dockerfile.
    - Version 2: Build the chat server on your host computer and copy the JAR file into the Dockerfile.

## Version 1: Building Inside the Dockerfile

### Dockerfile

```dockerfile
# FROM ubuntu:latest
# LABEL authors="Kenny"

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN chmod +x gradlew

EXPOSE 8080

CMD ["./gradlew", "runServer"]
```

## Instructions

1. Build Docker Image:
    ```bash
    docker build -t your_dockerhub_username/chat_server:v1 .
    ```

2. Run Docker Container:
    ```bash
    docker run -p 8080:8080 your_dockerhub_username/chat_server:v1
    ```
   
3. Run Chat Client:
    - On your host computer, execute the following command to run the chat client and connect to the server:
    ```bash
    ./gradlew runClient
    ```

4. Run Chat Client:
    - On your host computer, execute the following command to run the chat client and connect to the server:
    ```bash
    ./gradlew runClient
    ```

# Version 2: Building on Host and Copying JAR
## Dockerfile
    
```dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/basic_demo-0.1.0.jar /app/basic_demo-0.1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "basic_demo-0.1.0.jar"]
```

## Instructions
1. Build Project on Host:
    ```bash
    ./gradlew build
    ```
   
2. Build Docker Image:
    ```bash
    docker build -t your_dockerhub_username/chat_server:v2 .
    ```
   
3. Run Docker Container:
    ```bash
    docker run -p 8080:8080 your_dockerhub_username/chat_server:v2
    ```
   
4. Run Chat Client:
    - On your host computer, execute the following command to run the chat client and connect to the server:
    ```bash
    ./gradlew runClient
    ```

## Docker Hub
- Ensure you have tagged your images correctly and published them to Docker Hub:
    ```bash
    docker tag your_dockerhub_username/chat_server:v1 your_dockerhub_username/chat_server:v1
    docker push your_dockerhub_username/chat_server:v1
    ```

    ```bash
    docker tag your_dockerhub_username/chat_server:v2 your_dockerhub_username/chat_server:v2
    docker push your_dockerhub_username/chat_server:v2
    ```

## Technical Justification
- Version 1: Building the application inside the Dockerfile ensures the entire build process is containerized, which can be useful for ensuring consistent build environments.
- Version 2: Building the application on the host and copying the JAR into the Docker image can reduce the build time inside Docker and leverage the host's build tools, which might be more efficient.

## Conclusion
By following these steps, you have successfully containerized the chat server application using Docker. You explored two different approaches to building and running Docker containers, providing flexibility depending on the project requirements.