## Pre-Requisites

* install java jdk 8 [https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
* install maven [https://maven.apache.org/install.html](https://maven.apache.org/install.html)
* install mysql [https://www.mysql.com/downloads/](https://www.mysql.com/downloads/)


## Pre-Actions

* create the databased named "anymind_bitcoin" in mysql local db, using the SQL "CREATE DATABASE `anymind_bitcoin` /*!40100 COLLATE 'utf8mb4_unicode_ci' */;"
* open the application.properties file and edit the database connection informations under the #datasource section

## Usage
All commands should be run under root folder
 
Build the project:

* ```./mvn clean install ``` (build with already running docker containers. Will reduce time of the build)

Run Ptoject:

* ```java -jar target/bitcoin-0.0.1-SNAPSHOT.jar```

Default URL for GUI user:
* http://localhost:8080/swagger-ui.html