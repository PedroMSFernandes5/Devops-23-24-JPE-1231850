Guide for Setting Up and Executing Development Projects in a Virtual Machine - CA3 Parte1

Introduction
This guide delineates the procedures for configuring and testing various development projects within a Virtual Machine (VM) running Ubuntu 22.04.3 LTS. The primary focus revolves around Java-based applications utilizing Spring Boot and Gradle.

Getting Started
Follow these steps to set up and launch the projects on your local machine for development and testing purposes.

Prerequisites
Ensure the following prerequisites are met:

- VirtualBox or any other VM software.
- SSH client for remote VM connection.
- Access to a command-line interface.

Setup Procedures

Step 1: Access the Virtual Machine via SSH
Initiate a remote connection to the VM using SSH. Use the IP address 192.168.64.3 obtained from the VM's network configuration.

```bash
ssh pedro@192.168.64.3
```

Upon connection, you'll receive system status information including memory usage, system load, and available updates.

Step 2: Clone the Spring Boot and Gradle Project
Within the VM, clone the repository containing the Spring Boot and Gradle project.

```bash
git clone https://github.com/spring-guides/tut-react-and-spring-data-rest.git
cd tut-react-and-spring-data-rest/basic
```

Step 3: Install JDK and Manage Dependencies
Attempt to execute the Spring Boot application. If you encounter an error regarding JAVA_HOME not being set, it indicates Java is not configured correctly.

```bash
./mvnw spring-boot:run
```

Realize Java needs installation and configuration:

```bash
sudo apt install openjdk-8-jdk-headless
```

Encounter issues fetching the package, implying potential repository or network problems. Resolve by updating the package list and retrying the installation:

```bash
sudo apt update
sudo apt install openjdk-8-jdk-headless --fix-missing
```

After successful installation, set JAVA_HOME and update alternatives to ensure proper Java version handling.

Step 4: Configure JAVA_HOME
Add JAVA_HOME to environment variables:

```bash
echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc
source ~/.bashrc
```

Step 5: Re-run the Application
With Java installed and configured, rerun the Spring Boot application:

```bash
./mvnw spring-boot:run
```

Step 6: Access the Web Application from the Host Machine
To verify correct operation, access the web application from a browser on the host machine using the VM's IP address and appropriate port.

Step 7: Cloning and Setting Up Your Specific Project Repository
Cloning the Repository
Attempt to clone the repository using SSH. Encounter permission issues, likely due to missing or misconfigured SSH keys.

```bash
git clone https://github.com/PedroMSFernandes5/Devops-23-24-JPE-1231850
```

Switch to HTTPS for cloning, which should be successful:

```bash
git clone https://github.com/PedroMSFernandes5/Devops-23-24-JPE-1231850
```

Preparing the Project
Navigate to the project directory and list its contents to verify cloning:

```bash
cd Devops-23-24-JPE-1231850
ls
```

Executing a Spring Boot Project
Navigate to the specific Spring Boot project directory within the repository:

```bash
cd CA1/basic
```

Attempt to run the Spring Boot project using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

The application should compile and run successfully, serving a web application on port 8080.

Access the Web Application
Access the web application via the browser on the host machine using the VM's IP address and port 8080.

Step 8: Configuring and Running the React and Spring Data REST Project
Setting Up the Environment
Encounter issues with project execution due to Java version compatibility. Verify the installed Java version:

```bash
java -version
```

Attempt to install Java 17, facing delays due to locked dpkg processes caused by automatic upgrades.

```bash
sudo apt install openjdk-17-jdk-headless
```

After installation, navigate to the project directory and execute the project using Gradle:

```bash
./gradlew bootRun
```

Resolving Gradle Issues
Initially, face build failures due to mismatching Java versions and incompatible dependencies. After updating to Java 17, these issues should be resolved.

Application Output
The application should start with Spring Boot, confirming server initialization and service availability on port 8080.

Step 9: Creating a New Project Component (CA3)
Create a new component named CA3:

```bash
cd ~/Devops-23-24-JPE-1231850
mkdir CA3
cd CA3
touch README.md
```

Tagging the Repository
At the end of this phase, tag your repository with ca3-part1:

```bash
git tag ca3-part1
git push origin ca3-part1
```

Objective of Component CA3
The README.md file facilitates future documentation of developments and functionalities added under this component. This template ensures clear documentation of steps and intentions for review or continuation of work in future sessions.