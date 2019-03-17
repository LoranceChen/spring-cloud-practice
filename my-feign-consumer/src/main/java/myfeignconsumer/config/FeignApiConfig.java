package myfeignconsumer.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = {"myfeignunion.api"})
@Import({FeignApiConfig.MyfeignUnionAppApi.class})
public class FeignApiConfig {

    @EnableFeignClients("myfeignunion.api")
    @ComponentScan(basePackages = {"myfeignunion.api"})
    public static class MyfeignUnionAppApi {}

}
