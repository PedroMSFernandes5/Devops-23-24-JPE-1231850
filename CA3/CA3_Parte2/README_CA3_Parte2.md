Technical Report for CA3-Part2

Introduction
This technical report pertains to Class Assignment 3 - Part 2 of the DevOps course offered by "Switch - Curso de Especialização em Desenvolvimento de Software," completed by Pedro Fernandes, student number 1231850.

This report serves as a comprehensive documentation of the steps executed to fulfill the assignment, encompassing the commands utilized, encountered challenges, and the subsequent resolutions. The tutorial segment furnishes a systematic guide to accomplishing the assignment objectives.

Upon installing Ubuntu 20.04.3 LTS on VirtualBox, the subsequent measures were undertaken to finalize the assignment:

1. Pre-requisites
Ensure the repository is public.
Install Vagrant.
Install VirtualBox.
Launch VirtualBox.
Execute vagrant init within the designated project folder, in this instance, the CA3-Part2 folder.

2. Modify Vagrantfile
Modify the Vagrantfile provided by the instructor in the CA3-Part2 repository.
Adjust the Ubuntu version to 20.04.3 by replacing "ubuntu/bionic64" with "generic/ubuntu2004" three times in the script.

3. Adjust the Timeout Period
In my case, the script execution time was prolonged, halting at the "==> default: Waiting for SSH to become available..." message. Therefore, a timeout was introduced to expedite the script execution.

4. Update JPA from 11 to 17
In the Vagrantfile, update the JPA version from 11 to 17 by substituting "openjdk-11-jdk-headless" with "openjdk-17-jdk-headless."

5. Modify the git Clone and Implement Application Execution Commands
Revise the git clone to my GitHub public repository. After a clean build, append gradlew bootRun to initiate the application.

```bash
git clone https://github.com/PedroMSFernandes5/Devops-23-24-JPE-1231850
cd devops-23-24-JPE-1231850/CA2/part2/react-and-spring-data-rest-basic
chmod u+x gradlew
./gradlew clean build
./gradlew bootRun
```

6. Configure the H2 Database
Adjust the H2 database configurations to enable the project to read from the database and display entries on the web page. Review the commits on the repository for the alterations made to the project. Edit the application.properties file in the CA2-part2 project to utilize the H2 database.

```properties
# Configure H2 Database
server.servlet.context-path=/basic-0.0.1-SNAPSHOT
spring.data.rest.base-path=/api
spring.datasource.url=jdbc:h2:tcp://192.168.56.11:9092/./jpadb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.h2.console.settings.web-allow-others=true
```

```javascript
// Edit app.js file
(...)
client({method: 'GET', path: '/basic-0.0.1-SNAPSHOT/api/employees'}).done(response => {
(...)
```

```html
<!-- Edit the index.html file in the templates folder -->
(...)
<link rel="stylesheet" href="main.css" />
```

Commit the changes to the remote repository.

To access the H2 database, navigate to the address: http://192.168.56.11:8082. Utilize the following JDBC URL in the H2 console: jdbc:h2:tcp://192.168.56.11:9092/./jpadb. Fill in the remaining fields with default values.

Utilize the select * from entry; command to view database entries. Employ the insert command to insert new entries into the database.

6. Execute the Project
Launch the project with the command vagrant up.

If issues persist, execute vagrant destroy to delete the machines, followed by vagrant up. Access the application on the web browser via http://192.168.56.10:8080/basic-0.0.1-SNAPSHOT/, as defined in the Vagrantfile of the 'web' machine.

7. Terminate the Project
Halt the project execution with the command vagrant halt.

8. Reload/Restart the Project
To reset the project, execute the command vagrant reload.

Alternative to VirtualBox
A Vagrantfile was created to run using Qemu. The primary distinctions are outlined below:

```ruby
# Define db machine configuration
config.vm.define "db" do |db|
    db.vm.box = "generic/ubuntu2004"
    db.vm.hostname = "db"

    # Qemu provider settings
    db.vm.provider "qemu" do |qe|
      qe.arch = "x86_64"
      qe.machine = "q35"
      qe.cpu = "host"
      qe.memory = "512"
    end
```

In Qemu, Vagrant does not download the machine image. A script was appended to download the image prior to executing the vagrant up command.

```bash
config.vm.provision "shell", run: 'once', inline: <<-SHELL
    if [ ! -f ubuntu2004.img ]; then
      wget https://cloud-images.ubuntu.com/focal/current/focal-server-cloudimg-amd64.img -O ubuntu2004.img
    fi
  SHELL
```

Subsequent steps remain identical to those for VirtualBox.