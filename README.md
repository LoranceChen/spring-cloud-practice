# Spring Cloud Practice
test workflow of the spring cloud mainstream component.

## Projects / Modules
### my-config
- spring-cloud-config
    - centralize config app based on Git
- todo
    - support auto fresh config when remote config source changed.
        
### order-app
- a spring-boot app test my-config project
  
## How to Run (on IDE)
1. run `my-config`
    - access `http://localhost:8888/foo/default`
    
2. run `order-app`
    - access `http://localhost:8081/myname`
