# Technical Report for CA2-Part1

## Introduction

This is a technical report written by Pedro Fernandes, student number 1231850, for Class Assignment 2-Part 1 of the DevOps course from "Switch - Curso de Especialização em Desenvolvimento de Software".

The technical report that follows gives a thorough explanation of the procedures used to finish the task, including the commands used, the problems encountered, and the remedies put in place. The assignment tasks are explained in detail in the tutorial section.

## 1. Guide

1. On the Devops repository generated on CA1, create the CA2.Part1 directory.
2. Download and add to the Part1 directory the file https://bitbucket.org/pssmatos/gradle_basic_demo/.
3. Go over the readme.md file's instructions and play around with the application.
4. Create a new server task.
5. Include the provided unit test and run it.
6. Create a new task of type Copy to be used for backing up the application's sources.
   The src folder's contents ought to be copied to a fresh backup folder.
7. Include a new task of type Zip that will be used to create an archive, or zip file, of the application's sources.
   The src folder's contents ought to be copied to a fresh zip file.
8. At the conclusion of this assignment's first phase, tag your repository with the name ca2-part1.

### 1. Create CA2.Part1 directory on the Devops repository created on CA1.

```bash
mkdir CA2.Part1
```

### 2. Download https://bitbucket.org/pssmatos/gradle_basic_demo/ and add it to the Part1 directory.

```bash
git clone https://bitbucket.org/pssmatos/gradle_basic_demo/
```
Note: when transfer the content of the gradle_basic_demo to the CA2.Part1 directory, the .git directory should be removed.

```bash

## 3. Read the instructions available in the readme.md file and experiment with the application.

```bash
cd gradle_basic_demo
```
### Build
To build a .jar file with the application:

```bash
./gradlew build
```

### Run the server
Open a terminal and execute the following command from the project's root directory:
```bash
java -cp build/libs/basic_demo-0.1.0.jar basic_demo.ChatServerApp <server port>
```
Substitute by a valid por number, e.g. 59001

### Run a client
Open another terminal and execute the following gradle task from the project's root directory:
```bash
./gradlew runClient
```

After the build command the server and clients should be run in different terminals. The server should be run first.
The opened windows for the clients ask for a name and after that the messages can be sent between the clients.

### 4. Add new task to server.
On the build.gradle file, add the following task to the server:
```bash
task runServer(type:JavaExec, dependsOn: classes){
    group = "DevOps"
    description = "Launches a chat server that listens on port 59001"

    classpath = sourceSets.main.runtimeClasspath

    mainClass = 'basic_demo.ChatServerApp'

    args '59001'
}
```
Now the server can be run with the following command:
```bash
./gradlew runServer
```

### 5. Add given unit test and execute it.
Create a test directory on the src directory and add the following test to the Apptest.java file:
```java
@Test
public void testAppHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
        }
}
```

Run the test with the following command:
```bash
./gradlew test
```

### 6. Add a new task of type Copy to be used to make a backup of the sources of the application.
On the build.gradle file, add the following task to copy the src directory to a backup directory:
```bash
task backupSources(type: Copy) {
    from 'src'
    into 'backup'
}
```

Now the backup can be made with the following command:
```bash
./gradlew backupSources
```

### 7. Add a new task of type Zip to be used to make an archive (i.e., zip file) of the sources of the application.
On the build.gradle file, add the following task to zip the src directory:
```bash
task zipSources(type: Zip) {
    from 'src'
    archiveFileName = 'src.zip'
    destinationDir file('backup')
}
```
The src.zip file will be created in the backup directory.

Now the zip can be made with the following command:
```bash
./gradlew zipSources
```

### 8. At the end of the part 1 of this assignment mark your repository with the tag ca2-part1.
```bash
git tag ca2-part1
git push origin ca2-part1
```

