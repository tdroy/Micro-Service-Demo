The gateway service act as reverse proxy for registered service. Client must not access back end service directly and no need to know the address for each service.

There is NetFlix Zuul which does same thing as Spring Cloud Gateway, however Zuul is thread blocking and requires more resource. Where Spring Cloud Gateway is non-blocking which mean threads are not kept waiting unless request completes. Hence there will be always available thread for incoming request.

Again Gateway configuration done at application.yaml.

```
server:
  port: 8080
 
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:9001/eureka  

spring:
  application:
    name: gateway-service
  cloud:
    gateway:
      routes:
      - id: schoolModule
        uri: lb://SCHOOL-SERVICE
        predicates:
        - Path=/school/**
      - id: studentModule
        uri: lb://STUDENT-SERVICE
        predicates:
        - Path=/student/**
```

Here gateway service is listening on 8080 port. Its also register to same Eureka instance mentioned in ```defaultZone``` .

Important section is ```routes```. You can define multiple routes.
```id``` : route name
```uri``` : here we mention the ```lb``` and the service name in Eureka registry.
```Path``` : the context which will use to route request.
