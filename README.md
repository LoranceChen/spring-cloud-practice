# Spring Cloud Practice
test workflow of the spring cloud mainstream component.  

See [ha-feature](https://github.com/LoranceChen/spring-cloud-practice/tree/ha-feature) git branch for Full Spring Cloud Cluster practice.

## Projects / Modules
### my-config
- spring-cloud-config
    - centralize config app based on Git
- todo
    - support auto fresh config when remote config source changed.

### my-eureka
- spring-cloud-netflix-eureka
- todo
    - setting up multiple eureka node
    
### order-app
- a spring-boot app test my-config & my-eureka project

### my-zuul
- spring-cloud-netflix-zuul

### book-app
- a spring-boot app only test zuul

### my-ribbon
- spring-cloud-netflix-ribbon

### job-app
- a spring-boot app only test ribbon

### my-hystrix
- spring-cloud-netflix-hystrix

### twitter-app
- a spring-boot app only test hystrix

### my-sleuth
- spring-cloud-sleuth

### wechart-app
- another spring-cloud-sleuth


## How to Run (on IDE)
### Config & Eureka
1. run `my-config`
    - access `http://localhost:8888/foo/default`

2. run `my-eureka`
    - access `http://localhost:8888/foo/default`
        
3. run `order-app`
    - access `http://localhost:8081/myname`
    - access `http://localhost:8081/service-instances/order_app`

### Zuul
4. run `book-app`
    - access `http://localhost:8091/available`

5. run `my-zuul`
    - access `http://localhost:8083/book_app/available`

### Ribbon
6. run `job-app`
    - with default profile
        - access `http://localhost:8092/greeting`
    - with inst2 profile
        - access `http://localhost:8093/greeting`

7. run `my-ribbon`
    - access `http://localhost:8084/hi`
   
### Hystrix
8. run `twitter-app`
    - access `http://localhost:8095/recommended`

9. run `my-hystrix`
    - access `http://localhost:8085/to-read`
    
### Sleuth
10. run zipkin server by docker: `docker run -d -p 9411:9411 openzipkin/zipkin`
    - access `http://localhost:9411/zipkin/`
    
11. run `my-sleuth`
    - access `http://localhost:6060/`

12. run `wechart-app`
    - access `http://localhost:6065/wechart`
    
## Notice
- custom config Git repo by fork `https://github.com/LoranceChen/spring-cloud-config-repo.git`