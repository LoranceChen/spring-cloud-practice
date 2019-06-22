package myfeginreact.controller;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@RestController
@Headers({ "Accept: application/json" })
public class IcecreamServiceImp implements IcecreamServiceApi{

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

    @Override
    public Mono<String> payBill() {//(String bill) {
        Mono<String> a =  Mono.just("123aaa");
        return a;
    }
}