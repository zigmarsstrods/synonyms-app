# Synonyms REST API

## Description

REST API using JAVA, Spring Boot and Maven that allows to enter an English word in URL path and receive all synonyms of
the word as response. Synonym data is taken from [Dictionary API](https://dictionaryapi.dev/)

## Setup

Just clone this repository

## Usage

1. Open command line/console of Your system with a user account that has admin rights
2. Go to the directory where the project was previously cloned
3. Run the app via command `mvnw spring-boot:run`

### Endpoints

After running endpoint description is available in [Swagger](http://localhost:8080/swagger-ui/index.html)
![Swagger](swagger.png)

## Tests

The unit tests of the app can be run via  `mvnw test`