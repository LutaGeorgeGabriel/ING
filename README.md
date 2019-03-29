# ING Mortgages API

The following assessment consists in a REST API built using Spring framework.

## Backend

At root, the project is created as a SpringBoot application. I used Maven as a software management tool, in order to manage all the dependencies involved. The `pom.xml` file is also created using [Spring Initializr](https://start.spring.io/)

When creating the model classes for the entities involved in the assignment, I have also used
[Lombok](https://projectlombok.org/) in order to minimize the amount of code written, by having this
tool generate boilerplate code (such as setters and getters) at runtime.

When building the REST API, I have followed a classic Spring web application architecture, by providing:

* __Model:__ Entity's class model with fields and methods (__MortgageInfo__ & __MortgageRate__)
* __Service:__ Provides specific operations for the respective entity.
* __Configuration:__ Provides the beans for the entity, in order to be injected wherever needed.
* __Repository:__ As the challenge implied saving the objects in memory, I have created a `MortgageRepository` entity to store all the data during runtime. This proved to be also very useful when writing the tests as well.
* __Controller:__ Basic REST API which supports fetchning and posting data to the API, with the needed parameters.

### Steps of improvement:
* validate and parse the data received by POST endpoint
* make POST endpoint return a `Map<Boolean,Double>` in order to avoid the usage of the not-so-specific mortgage decline flag
* have 100% code coverage

### Steps to run the app:
* 1st - open a new terminal tab and execute `mvn spring-boot:run` inside  _/ING-Mortgages-API_
