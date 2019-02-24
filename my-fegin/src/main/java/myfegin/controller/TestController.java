package myfegin.controller;

import myfegin.service.FeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    FeginClient feginClient;

    @GetMapping("/order-name")
    public String test() {
        return feginClient.getOrderAppName();
    }

    @GetMapping("/order-some-data")
    public FeginClient.SomeData someData() {
        return feginClient.getOrderSomeData();
    }
}
