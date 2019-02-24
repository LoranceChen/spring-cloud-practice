package myfeign.controller;

import myfeign.service.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    FeignClient feignClient;

    @GetMapping("/order-name")
    public String test() {
        return feignClient.getOrderAppName();
    }

    @GetMapping("/order-some-data")
    public FeignClient.SomeData someData() {
        return feignClient.getOrderSomeData();
    }
}
