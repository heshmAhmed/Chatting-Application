# Chatting-Application

> JavaFx Chatting Application with RMI Client Server model - ITI 9-months scholarship java track - JETS

> Layered architecture & Multi Module Project & Mysql db

## Client project 
  Responsible for client side (Javafx GUI)

## Server project
  Responsible for server side, rmi, admin app

## Common project 
  Responsible for handling interfaces and dtos used by client and server
  
  
## DB
Using Hikaricp pooling to handle multiple connection to database

## Requirement

##### Java SE 11
##### Javafx 17.0.2
##### Apache Maven 3.8.4

## How to run

#### Install the Common Project

Go to the Common project & in your terminal

```
mvn clean compile install
```

#### Run the Server Project

Go to the Server project & in your terminal

```
mvn clean compile javafx:run
```

#### Run the Client Project

Go to the Client project & in your terminal
``` 
mvn clean compile javafx:run
```
