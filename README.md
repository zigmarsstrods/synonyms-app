# Synonyms REST API

## Description

REST API using JAVA, Spring Boot and Maven that allows to enter an English word in URL link path and receive all synonyms of the word as response. Synonyms data teken from [Dictionary API](https://dictionaryapi.dev/)

## Setup

Just clone this repository

## Usage

1. Open command line/console of Your system with a user that has admin rights
2. Go to the directory where project was previously cloned
3. Run the app via command   `mvnw spring-boot:run`

### Endpoints

Available from localhost on port 8080: [http://localhost:8080/](http://localhost:8080/)

#### `GET /synonyms/{word}`

Enter the necessary word to get its synonyms as a list in the response page 

##### Example

![Example](example.png)

## Tests

The app unit tests can be run via  `mvnw test`