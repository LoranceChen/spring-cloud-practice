//package gateway.controller;
//
//import com.netflix.discovery.converters.Auto;
//import gateway.config.OrderAppConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//import reactor.core.publisher.Mono;
//
//@RestController
////@RibbonClient(name = "order_app", configuration = OrderAppConfig.class)
//public class TestController {
//
//    @Autowired
//    LoadBalancerClient loadBalancerClient;
//
////    @LoadBalanced
//    @Bean
//    RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//    @Autowired
//    RestTemplate restTemplate;
//
//    @GetMapping("/myname")
//    public String hi() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("order_app");
//
//        String greeting = this.restTemplate.getForObject("http://" + serviceInstance.getHost() +":"+ serviceInstance.getPort() + "/myname", String.class);
//        return greeting;
//    }
//
//
//    @GetMapping("name")
//    public Mono<String> getName() {
//        return Mono.just("name: gateway");
//    }
//}
