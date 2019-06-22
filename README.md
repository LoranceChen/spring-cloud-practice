# Spring Cloud Practice
test workflow of the spring cloud mainstream component.

The ha-feature branch represent High Available Spring Cloud.

## Projects / Modules
### my-config
- spring-cloud-config
    - centralize config app based on Git
- todo
    - support auto fresh config when remote config source changed.

### my-eureka
- spring-cloud-netflix-eureka

### order-app
- a spring-boot app test my-config & my-eureka project

### my-zuul
- spring-cloud-netflix-zuul

### my-feign-provider-union & my-feign-consumer
- spring-cloud-openfeign

### my-gateway
- spring-cloud-gateway

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

### sidecar
- verify non-jvm integrate to Spring Cloud
 
## How to Run (on IDE)
### Config & Eureka
1. run `my-config`
    - run profile `config1`
        - access `http://localhost:<port>/foo/default`, get `foo` properties from git repo 
        - access `http://localhost:<port>/myname`, verify git repo config
    - run profile `config2`
        - access `http://localhost:<port>/foo/default`, get `foo` properties from git repo 
        - access `http://localhost:<port>/myname`, verify git repo config
2. run multiple `my-eureka`
    - run profile `peer1`
        - access `http://localhost:8762`, eureka web dashboard
    - run profile `peer2`
        - access `http://localhost:8763`, eureka web dashboard

3. run `order-app`
    - access `http://localhost:<port>/myname`, verify git repo config
    - access `http://localhost:<port>/service-instances/order_app`, eureka register information

### Gateway
- run `my-gateway`
    - access `http://localhost:7082/order-app/myname`, forward to `order-app` application

### Zuul
4. run `book-app`
    - access `http://localhost:8091/available`

5. run `my-zuul`
    - access `http://localhost:8083/book_app/available`

### Feign
- run `my-feign-providor-union-app`
    - access `http://localhost:6091/feign-union-name` to verify API provider is UP
- run `my-feign-consumer`
    - access `http://localhost:6101/consumer-provider-info`
    
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
    
### Sidecar
- run `sidecar-app`(without eureka) as Non-JVM
- run `my-sidecar`
- run `my-gateway`
    - access `http://localhost:3201/sidecar-app/hello` //access Non-JVM app from outside
- run `order-app`

- access `http://localhost:3301/order.app/myname` //access jvm app from Non-JVM app

## Notice
- custom config Git repo by fork `https://github.com/LoranceChen/spring-cloud-config-repo.git`

## How to Manager Spring Cloud Cluster
- 启动顺序：Erueka服务优先启动，Config Server服务第二启动
- 每种类型的服务分ip端口段，比如~~Erueka服务的范围在[8760,8770)~~ ConfigServer的服务范围配置在8880-8889
    - Erueka服务注册需要手动设定端口，并且分别启动。
- Config App配置config server和client时，client会按照自身的server配置拉取自己的git config
- 同一个类型的App启动时，应该有相同的规则，不需要在逻辑上做区分
    - 可能会定义不同的配置，如启动端口。通过配置范围可用端口，如my_config的端口使用[8880. 8889)实现逻辑上不区分
- App的配置需要强制使用Spring Config Server，如果连接失败则程序启动失败
  - https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_client.html#config-client-fail-fast
  - https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_client.html#config-client-retry
- Eureka Client的Zone相关配置需要放在bootstrap文件中

## Good Practice
- use URI format as application name.

## Other Resource
- [eureka Rest operation](https://github.com/Netflix/eureka/wiki/Eureka-REST-operations)
-  random port
    - http://igormadjeric.blogspot.com/2017/06/running-spring-boot-web-app-on-random.html
    - https://www.baeldung.com/spring-boot-change-port
- [modify Config Server save default path](https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_server.html#_version_control_backend_filesystem_use)
- Config with Erueka
    - https://stackoverflow.com/a/49938548/4887726 
    - https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_client.html#discovery-first-bootstrap

## Blue Green Test
- use MyFeignProviderUnion and MyFeignConsumer module test default region based Eureka & Ribbon LB strategy
    - conclusion: Ribbon first use same region 
    - ?? 当设置不同的zone时
        - 并且依赖的服务有相同的zone那么客户端会调用这个相同的zone，但是，如果这时候依赖的zone服务挂了，那么
        当前的服务就一直获取不到。
        - 如果依赖的服务没有相同的zone，那么客户端会直接选择不同的zone
    - Eureka测试
       1. 不同的zone
            1）先启动后断开：等下次同步eureka时，自动切换到另一个zone
            2）不启动相同的zone：启动时会使用不同的zone
       2. 不同的region
            无效，无法限制
       3. zone的region都不同
    - Eureka的不同环境配置方案
        - [自定义环境配置变量](https://github.com/Netflix/eureka/wiki/Overriding-Default-Configurations)
        
## 优化
- 使用消息中间件实时推送eureka的变更，尤其是生产部署相关的东西。
    - 目标
        - 运维的实时更新
        - 更新各个服务模块需要同步的信息，不要全量同步
    - 方案
        - 查看Eureka Server是否有相关的hook代码可以注入。
        - 二次源码上的开发
- ribbon灰度发布支持
    - ribbon中获取Header中的灰度：
        - 借助sleuth的spanId，记录Http相关的信息到ConcurrentHashMap中，在Ribbon的choose方法中，
        获取该spanId，然后从HashMap获取关联的信息，返回一个Ribbon需要Server。
    - 确认部署灰度服务的app在依赖的服务中已经被识别。
    eureka和ribbon存在延迟，当灰度服务实例上线后，需要几分钟的时间才能同步，但是我们期望界面上能够看到灰度实例
    确实被ribbon识别到了。
        - 因为我们发布灰度时，知道发布了几个灰度实例。通过在ribbon客户端中确认该服务识别的灰度来验证。
    - 管理界面的支持
        - 灰度环境的每个实例通过图形的形式展示，并且按照不同的环境标签进行分组。
- 新的灰度库
    - 通过MQ推送实时数据的方式，实现实时同步变更注册信息
    
- todo灰度 
    - Header上添加Version，将Header传递到Eureka中