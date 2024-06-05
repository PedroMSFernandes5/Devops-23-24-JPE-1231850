
# Build Tools with Gradle - CA2 Part 1 Technical Report
## João Gonçalves 1130122

## Introduction

This document serves as a comprehensive technical report for Part 1 of the class assignment (CA2) for the DEVOPS course, focusing on "Build Tools with Gradle". It encompasses detailed steps taken from the provided README files to ensure a thorough understanding and replicability of the tasks involved in using Gradle for a simple example application.

## Getting Started

### Prerequisites

- Gradle
- JDK (Java Development Kit) 1.8 or higher
- Git
- JUnit 4.12 (for unit testing)

### Initial Setup

1. **Clone the example application**: `git clone https://bitbucket.org/pssmatos/gradle_basic_demo.git`
2. **Prepare the repository**:
    - Remove the `.git` file from the cloned repository.
    - Move all files inside the "gradle_basic_demo" directory to the CA2 directory in your own repository.
    - Add all new files to your GitHub repository.

### Running the Application

- **Build the project**: `./gradlew build` (or `gradle build` if you have Gradle installed locally).
- **Start the server**: `java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp 59001`.
- **Run the client**: `./gradlew runClient`.

## Task Implementations

### Run Client with Gradle Task

- **Task Definition**
  ```groovy
  task runClient(type: JavaExec, dependsOn: classes) {
    group = "DevOps"
    description = "Launches a chat client that connects to a server on localhost:8080 "

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatClientApp'

    args 'localhost', '8080'
  }
  ```


### Run Server with Gradle Task

- **Task Definition**:
  ```groovy
  task runServer(type: JavaExec, dependsOn: classes) {
    group = "DevOps"
    description = "Launches a chat server that listens on port 8080"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '8080'
  }
  ```
- **Execution**: `./gradlew runServer`.

### Unit Testing

- **Test Implementation**:
  ```java
  @Test
  public void testAppHasAGreeting() {
      App classUnderTest = new App();
      assertNotNull("app should have a greeting", classUnderTest.getGreeting());
  }
  ```
- **Running Tests**: `./gradlew test`.

### Backup and Archive Tasks

- **Backup Task**:
  ```groovy
  task copySource(type: Copy){
    group = "DevOps"
    description = "Copies source files to a backup directory"

    from 'src/'
    into 'backup'
  }
  ```
    - **Execution**: `./gradlew copy`.

- **Archive Task**:
  ```groovy
  task zip(type: Zip){
    group = "DevOps"
    description = "Zips the source files"

    from 'src/'
    archiveFileName = 'source.zip'
    getArchiveFile().set(layout.buildDirectory.file('backup/source.zip'))
  }
  ```
    - **Execution**: `./gradlew zip`.

## Conclusion

Following this document, you can replicate the setup, task implementations, and testing procedures for the Gradle project related to CA2 Part 1.
