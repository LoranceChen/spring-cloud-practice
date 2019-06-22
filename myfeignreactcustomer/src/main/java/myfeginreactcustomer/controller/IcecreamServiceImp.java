package myfeginreactcustomer.controller;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@RestController
public class IcecreamServiceImp {

    @Autowired
    myfeginreact.controller.IcecreamServiceApi icecreamServiceApi;
//    @RequestLine("GET /icecream/flavors")
//    Flux<String> getAvailableFlavors();
//
//    @RequestLine("GET /icecream/mixins")
//    Flux<String> getAvailableMixins();
//
//    @RequestLine("POST /icecream/orders")
//    @Headers("Content-Type: application/json")
//    Mono<String> makeOrder(String order);
//
//    @RequestLine("GET /icecream/orders/{orderId}")
//    Mono<String> findOrder(@Param("orderId") int orderId);

    @RequestMapping(method = RequestMethod.GET,
            value = "/feign-react-customer-test")
    public Mono<String> payBill2() {//(String bill) {
        return icecreamServiceApi.payBill();
//        return  Mono.just("1234");
//        return icecreamServiceApi.payBill();
    }
}