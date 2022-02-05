## Pre-Requisites

* install java jdk 8 [https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
* install maven [https://maven.apache.org/install.html](https://maven.apache.org/install.html)
* install mysql [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/)


## Pre-Actions to be performed

* create the database named ```anymind_bitcoin``` in mysql local db, using the SQL ```CREATE DATABASE `anymind_bitcoin` /*!40100 COLLATE 'utf8mb4_unicode_ci' */;```
* open the ```application.properties``` file and edit the database connection information under the #datasource section

## Usage
All commands should be executed under root folder of the project
 
Build the project:

* ```./mvn clean install ```

Run Project:

* ```java -jar target/bitcoin-0.0.1-SNAPSHOT.jar```

Default URL for GUI user:
* http://localhost:8080/swagger-ui.html
* use the ```bit-coin-controller``` in the swagger UI to test the REST APIs

## Points to be noted
* Project is configured with Spring + REST + JPA (Hibernate)
* Project has, controller layer, Service layer, Repository layer and Entity
* named query is implemented in Repository
* validations are handled by javax.validation
* Interface-based DTO projections is implemented for native query
* ```Lombok``` is implemented
* ```flywaydb``` is implemented for database migration and update
* ```slf4j``` is implemented with spring log-back
* validation is done at the controller level
* No Spring Security features added to the project
* swagger API documentation is implemented and swagger UI is implemented for easy testing of application
* editing of ```application.properties``` file is required to connect to local mysql database
* spring actuator is added to project
* spring Junit5 integration test is added to project