package myconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.util.Collections;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class MyConfigApplication {
    public static void main(String[] args) {
//        SpringApplication.run(MyConfigApplication.class, args);
        SpringApplication app = new SpringApplication(MyConfigApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);

    }

}
