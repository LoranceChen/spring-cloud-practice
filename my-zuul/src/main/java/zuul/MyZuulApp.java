package zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import zuul.filter.pre.SimpleFilter;

//@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class MyZuulApp {

    public static void main(String[] args) {
        SpringApplication.run(MyZuulApp.class, args);
    }

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }


}