package mysleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class MySleuthApp {

    private static Logger log = LoggerFactory.getLogger(MySleuthApp.class);

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    SomeUtil someUtil;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String home() {
        log.info("Handling home");
        someUtil.getUserName("my id");
        String wechartResponse = this.restTemplate.getForObject("http://localhost:6065/wechart", String.class);

        log.info("home response - " + wechartResponse);
        return "Hello World. " + wechartResponse;
    }


    public static void main(String[] args) {
        SpringApplication.run(MySleuthApp.class, args);
    }

}