# Spring Cloud Practice
test workflow of the spring cloud mainstream component.

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

## How to Run (on IDE)
1. run `my-config`
    - access `http://localhost:8888/foo/default`

2. run `my-eureka`
    - access `http://localhost:8888/foo/default`
        
3. run `order-app`
    - access `http://localhost:8081/myname`
    - access `http://localhost:8081/service-instances/order_app`

4. run `book-app`
    - access `http://localhost:8091/available`
    
5. run `my-zuul`
    - access `http://localhost:8083/book_app/available`
    
## Notice
- custom config Git repo by fork `https://github.com/LoranceChen/spring-cloud-config-repo.git`