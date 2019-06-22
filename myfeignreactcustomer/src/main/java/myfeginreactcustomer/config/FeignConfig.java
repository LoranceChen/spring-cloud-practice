package myfeginreactcustomer.config;

import myfeginreact.controller.IcecreamServiceApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactivefeign.webclient.WebReactiveFeign;

@Configuration
public class FeignConfig {

    @Bean
    public IcecreamServiceApi getIceApi() {
        IcecreamServiceApi client =
                WebReactiveFeign  //WebClient based reactive feign
                        //JettyReactiveFeign //Jetty http client based
                        //Java11ReactiveFeign //Java 11 http client based
                        .<IcecreamServiceApi>builder()
                        .target(IcecreamServiceApi.class, "http://localhost:8080");

        return client;
    }

}
