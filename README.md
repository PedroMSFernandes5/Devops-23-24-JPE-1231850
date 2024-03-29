﻿# Devops-23-24-JPE-1231850

 # Technical Report for CA1

## Introduction

The technical report that follows gives a thorough explanation of the procedures used to finish the task, including the commands used, the problems encountered, and the remedies put in place. The instructional and the procedures make up the two main components of the report. While the procedures part lists the commands and steps needed to complete the assignment requirements, the tutorial section offers a step-by-step walkthrough of the tasks involved in the assignment.

## Tutorial
Establishing a new Git repository and configuring it for the project is the first step in the assignment. To accomplish this, create a new GitHub repository, set up a local repository, add a README file, and push the first commit to the remote repository.
1. Open a new GitHub repository.
2. Set up your local repository.
3. Add a README file. When a repository is created on gitHub without a README file, the following actions are recommended.
Open issues in the repository in order to keep track of the assignment tasks. The commits should contain references to the issues.

```bash
echo "# repository-name" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:PedroMSFernandes5/Devops-23-24-JPE-1231850.git
git push -u origin main
```
To prevent superfluous files from being added to the repository, a.gitignore file needs to be established. The file can be created with the following command.
The text of the.gitignore file can be copied from the provided website and pasted into the file by using the nano command.
It is recommended that the.gitignore file include the.idea directory.

```bash  
touch .gitignore
nano .gitignore
```

## Procedures

On the command line or in Git Bash, use de following commands to respond to the tasks of the assignment:

### Overview

The task comprises multiple essential tasks:


1. Moving the Spring Data REST Application and Tutorial React.js code into a new folder called CA1.
2. Transfer the "pom.xml" file and the Basic directory to the newly created folder. 
3. Sending the modified files to the repository and committing them
4. Pushing the tag to the server and tagging the first version as v1.1.0.
5. Creating a new feature: giving the Employee object a "jobYears" field.
6. Writing unit tests to verify that the new field is valid for only integer values.
7. Troubleshooting the solution's client and server components.
8. Pushing the updates, marking the repository as v1.2.0, and committing the new functionality.
9. Use the tag ca1-part1 to conclude part one.
10. Adding new features to branches that correspond to the features. For instance, adding a new email field to the program by making a branch called "email-field".
11. Designate v1.3.0 for the repository.
12. Making the fix-invalid-email branch. Only workers with active email addresses (those that contain the "@" symbol) should be allowed to access the server.
13. Marking the repository as v1.3.1, merging into the master branch.
14. Tag the repository with ca1-part2 when the assignment is finished.

#### Copying the Tutorial Application

Copy the code of the Tutorial React.js and Spring Data REST Application into a new folder named CA1.

```bash
    git clone https://github.com/spring-guides/tut-react-and-spring-data-rest
````
#### Adding the Basic Directory and the _pom_.xml File
```bash
    cp -r tut-react-and-spring-data-rest/basic CA1
    cp tut-react-and-spring-data-rest/pom.xml CA1
    cd CA1
    git init
    git add .
    git commit -m "#x message"
   git 
```

````bash
git rm -df <file or folder>
git status
git push origin main
````

#### Create a new tag v1.1.0 and push it to the server

```bash
    git tag v1.1.0
    git push origin v1.1.0
```

In the backend, add a new field named "jobYears" to the Employee entity. Make changes to the constructor, getter, and setter methods, and add validation annotations.
The tests directory needs to have new tests added for the "jobYears" property.
The javascript code needs to be changed in order to display the new field on the frontend.
The DatabaseLoader class must be modified in order to include the new field in the original data.

#### Finalizing and tagging the New Feature

After implementing features and fixes, commit, push, and tag the repository accordingly:

```bash
    git add .
    git commit -m "#x Add jobYears field to Employee entity."
    git push origin main
    git tag v1.2.0
    git push origin v1.2.0
```

#### Final Tagging
End part one with the tag ca1-part1:

```bash
    git tag ca1-part1
    git push origin ca1-part1
```

#### Email adding

To add a new email field to the application, create a new branch. Once the feature has been implemented, tag the repository and merge it into the master branch:

```bash
    # create a new branch
    git checkout -b email-field
    # add the email field to the Employee entity
    git add .
    git commit -m "#x Add email field to Employee entity."
    git push origin email-field
    git checkout main
    git merge email-field
    git push origin main
    git tag v1.3.0
    git push origin v1.3.0
```
#### Fixing Invalid Email Issue

To resolve the invalid email issue, create a new branch and merge it into the master branch:
The Employee entity needs to provide a way to verify email addresses.
To make sure that only legitimate email addresses are allowed, tests should be developed.

```bash
    # create a new branch
    git checkout -b fix-invalid-email
    # fix the issue
    git add .
    git commit -m "#x Fix invalid email issue."
    git push origin fix-invalid-email
    git checkout main
    git merge fix-invalid-email
    git push origin main
    git tag v1.3.1
    git push origin v1.3.1
```

#### Final Tagging

At the end of the assignment, mark the repository with the tag ca1-part2:

```bash
    git tag ca1-part2
    git push origin ca1-part2
```

## 2. Analysis of an Alternative Version Control Solution: Mercurial SCM

This section provides an analysis of Mercurial as an alternative version control solution to Git, focusing on its features, differences from Git, and its application to the assignment goals.

### Comparison to Git

1. **Ease of Use**:
   - Mercurial is praised for its simplicity and straightforward command set.
   - New users might find Mercurial more approachable than Git due to its simplicity.

2. **Branching and Merging**:
   - Mercurial supports branching and merging, but Git's model allows more flexibility with lightweight branches.

3. **Performance**:
   - Git generally offers better performance for large projects due to its efficient handling of branches and data format.
   - Mercurial provides sufficient performance for most projects.

4. **Tooling and Integration**:
   - Git has a broader adoption and more tools available, including GitHub, GitLab, and Bitbucket.
   - Mercurial is supported by many tools but has a smaller ecosystem.

### Applying Mercurial to the Assignment Goals

To achieve the same goals using Mercurial:
1. Initialize a Mercurial repository with `hg init`.
2. Use `hg add`, `hg commit`, and `hg push` for version control operations.
3. Create branches with `hg branch`, merge with `hg merge`, and tag with `hg tag`.
