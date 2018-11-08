package bookserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableEurekaClient
@RestController
@SpringBootApplication
public class BookApp {

    @RequestMapping(value = "/available")
    public String available() {
        System.out.println("get abailable - ");

        return "Spring in Action";
    }

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApp.class, args);
    }
}