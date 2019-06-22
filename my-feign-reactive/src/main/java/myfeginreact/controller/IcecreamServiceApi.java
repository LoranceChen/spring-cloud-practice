package myfeginreact.controller;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Headers({ "Accept: application/json" })
public interface IcecreamServiceApi {

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
            value = "/feign-react-test")
//    @RequestLine("GET /icecream/bills/pay")
//    @Headers("Content-Type: application/json")
    Mono<String> payBill();
}