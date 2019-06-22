package myfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients({"myfeignconsumer"})
public class MyFeignConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyFeignConsumerApplication.class, args);
    }

}
