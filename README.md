# Micro-Service-Demo
This is an introduction to microservice based on spring cloud gateway with eureka 

Spring boot based of spring framework which gives developers a faster way to develop, test and deploy. Spring boot containers are based on tomcat.
NetFlix Eureka provide discovery services for all micro services and maintain the registry of service, each of services can talk to each other.
Spring cloud gateway deliver single entry point for clients to consume all these services, it acts as proxy and its non-blocking thread mechanism has higher performance as threads will not wait request to complete.

This project has four parts.

1)	troy-eureka-server – spring boot project initiate Eureka server.
2)	troy-gateway-service – spring cloud act as reserve proxy between service.
3)	troy-school-service – a backend simple school service uses student service internally using eureka discovery.
4)	troy-student-service – a backed simple student service, and register to eureka server.

Open four command prompt or terminal for each project and run ‘mvnw spring-boot:run’. This will bring the services up.
Eureka server is available on http://localhost:9001
 
For eureka server clustering refer to another document inside.
