This project will start eureka server as spring-boot application.

The configuration is done on application.yaml.
---
server:
  port: 9001    
    
spring:
  application:
    name: eureka-server-clustered   
    
eureka:
  datacenter: Main
  environment: prod
  instance:
    hostname: localhost  
  client:
    registerWithEureka: true
    fetchRegistry: true       
    serviceUrl:
      defaultZone: http://localhost:9002/eureka
--
Where instance is running on 9001. 
And Eureka configuration easy to understand. In case clustering required for eureka server the start another Eureka instance on different port (9002) and define in ‘defaultZone’. Where ‘registerWithEureka’ & ‘fetchRegistry’  allow services to copied in Eureka cluster.
