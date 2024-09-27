# Seminar Hall Booking

### **Tasks before Live Coding Round**

1. Install and setup everything. Make sure you are able to run and test the application.
2. Go through the codebase and try to understand different aspects of the application.
3. Make notes of the doubts or problems you faced if any.

### About

The project is a Rest API application with **6** seminar halls - 

| Hall Name | Capacity |
| --------- | -------- |
| A         | 50       |
| B         | 100      |
| C         | 200      |
| D         | 350      |
| E         | 500      |
| F         | 1000     |

A starter code is provided for you **with all the libraries** required for the task. The application is built using **maven**, **JSON.simple**, **h2 database (SQL)** and **MVC** design pattern. You will be required to complete a function using **core JAVA**.

### Installation and Running

To run the starter code, go to the root directory of the project and run - 

```sh
> mvn clean compile assembly:single
> cd target
> java -jar java-assignment-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
You can also install and run using the IDE of your choice. Run `com.scry.assignment.Application` file through the IDE.

Open  http://localhost:8085/assignment/bookings in the browser to list all bookings and to confirm that everything is setup properly. Or you can use `postman` or any similar tools for the same. 

