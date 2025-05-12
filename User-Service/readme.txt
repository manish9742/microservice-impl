employee-service.yml

server:
  port: 8090

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/

logging:
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} ${LOG_LEVEL_PATTERN:-%5p} %m%n"
employee-service-instance2.yml

server:
  port: 9090

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/

logging:
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} ${LOG_LEVEL_PATTERN:-%5p} %m%n"
discovery-service.yml

server:
  port: 8061

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/