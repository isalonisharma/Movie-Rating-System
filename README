# Movie Rating System

In this project I'm demonstrating you the most interesting features of Spring-Boot Microservice-Based Architecture. 

1. Spring Cloud Netlix Eureka as a discovery server. Each Service when it comes online registers itself with Service Registry. When some other service wants to communicate with a already registered service, they would ask the Eureka Server the base url for that service. Multiple instances of the same service could register with Eureka, in that case Eureka could help in doing Load Balancing.

![Image of programexe](https://github.com/salonisharma8/Spring-Boot-MicroServices-POC/blob/master/images/discovery-server.png)

2. OpenFiegn for communication between microservice. In this project, Movie Catalog Microservice is having GET API for user catalog which takes information of movie from Movie-Information Microservice and rating from Rating-Data MicroService.

![Image of programexe](https://github.com/salonisharma8/Spring-Boot-MicroServices-POC/blob/master/images/FeignClient.png)

3. Hystrix Circuit Breaker provides alternative behavior in case certain microservice is gone down. This way the system gracefully switches to fallback behavior until the system recovers, rather than entire system suffering the ripple effects of failed service.

![Image of programexe](https://github.com/salonisharma8/Spring-Boot-MicroServices-POC/blob/master/images/hystrix-stream.png)

4. A Microservice environment needs a gateway. ZUUL Gateway is an entity exposed to the outside world, which allows access to Microservices and does more. A Gateway could do
API Metering, Centralized Authentication/Authorization, Load Balancing,etc

# Architecture

Every microservice is a Spring Boot application and can be started locally using IDE or ../mvnw spring-boot:run command. Please note that supporting services (Cloud Configuration Server, Dicovery Server and ZUUL API Gateway) must be started before any other application (User Microservice, Movie Catalog Microservice, Movie Information Microservice and Ratings Data Microservice). If everything goes well, you can access the following services.

### Cloud Configuration Server - http://localhost:8082

A module that uses Spring Cloud Config Server for running configuration server in the native mode. The configuration files are placed on the classpath.

### Discovery Server - http://localhost:8761

A module that depending on the example it uses Spring Cloud Netflix Eureka or Spring Cloud Netlix Alibaba Nacos as an embedded discovery server.

### Zuul API Gateway -  http://localhost:8081

A module that Spring Cloud Netflix Zuul for running Spring Boot application that acts as a proxy/gateway in our architecture.

### Other Microservices -

User Microservice, Movie Catalog Microservice, Movie Information Microservice, and Rating Data Microservice
