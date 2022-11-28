
# Forex

Forex is an exchange rate conversion application.


## Table of Contents

* General Info
* Description
* Technologies
* Run Locally
* Future Additions

## General Info

This project uses a Microservices architecture and has 6 services. The services are: 
Exchange Rate service, Conversion Service, API Gateway, Naming service, Forex Config server and Limits service.

## Description

* The app uses the API gateway to route calls to the exchange-rate and conversion services.
**NB:**
The conversion service calls the exchange-rate-service endpoint, using Feign, to get the numerous stored exchange rates (USD, GBP & EUR).
* The api-gateway, conversion-service, and exchange-rate-service are registered as clients to the naming-services (which uses Eureka).
* The conversion-service, exchange-rate-service, and limits-service are linked to the forex-config-service, with only the limits-service having configs set in the config service.
* Distributed Tracing and Logging is done in the api-gateway, conversion-service, and exchange-rate-service using Zipkin and Spring Cloud Sleuth.
* It must be noted that the Zipkin service and rabbitmq service are all docker images. 
## Technologies 

+ Springboot
+ H2 Database 
+ Docker
+ Spring Cloud
    - Zipkin and Sleuth
    - Eureka
    - Feign
    - Config server
+ RabbitMQ
+ Resilience4J


## Run locally


#### Main Steps:
+ Navigate to the Forex folder
+ Using maven configuration implemented in the api-gateway; exchange rate; and conversion service, build docker images of the mentioned services by navigating to the respective folders and running:
```bash
  mvn spring-boot:build-image -DskipTests
```
+ Navigate back to the Forex folder and run the project by starting the docker compose of the project. 
```bash
  docker compose up
```
+ Stop the services using 
```bash
  docker compose down
```
## Usage

#### Images

- Exchange Rate Service 
	- isaacafrifa/forex-exchange-rate-service:0.0.1-SNAPSHOT
- Conversion Service
	- isaacafrifa/forex-conversion-service:0.0.1-SNAPSHOT
- Eureka
	- isaacafrifa/forex-naming-service:0.0.1-SNAPSHOT
- API GATEWAY
	- isaacafrifa/forex-api-gateway:0.0.1-SNAPSHOT


#### URLS

+ Exchange Rate Service - http://localhost:8000/exchange-rate/from/USD/to/GHS
+ Conversion Service - http://localhost:8100/conversion/from/USD/to/GHS/quantity/10
+ Naming Service - http://localhost:8761/
+ Zipkin - http://localhost:9411/
+ RabbitMQ - http://localhost:15672/
+ API Gateway 
    - http://localhost:8765/exchange-rate/from/USD/to/GHS
    - http://localhost:8765/conversion/from/USD/to/GHS/quantity/10
## Future Work

To Be Considered ....
