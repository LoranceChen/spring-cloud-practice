package wechartapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WeChartApp {

    private static Logger log = LoggerFactory.getLogger(WeChartApp.class);

    @RequestMapping("/wechart")
    public String wechart() {
        log.info("wechart request");
        String friends = getFriends();
        return "some wechart, with friends: " + friends;
    }

    public String getFriends() {
        log.info("wechart get friends request");
        return "some friends";
    }

    public static void main(String[] args) {
        SpringApplication.run(WeChartApp.class, args);
    }

}
