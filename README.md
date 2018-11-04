# Spring Cloud Practice
test workflow of the spring cloud mainstream component.

## Projects / Modules
### my-config
- spring-cloud-config
    - centralize config app based on Git
- todo
    - support auto fresh config when remote config source changed.
- how to run
    - custom `spring.cloud.config.server.git.uri config` in `spring-cloud/my-config/src/main/resources/bootstrap.yml`
### order-app
- a spring-boot app test my-config project
  