package mywebflux.controller;

import brave.Tracer;
import brave.Tracing;
import mywebflux.config.MySleuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {
    @Autowired
    Tracer tracer;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/message")
    public Mono<String> getMessage() {
        redisTemplate.opsForValue().set("a", "b");
//        logger.info("extra: " + tracer.currentSpan().context().extra().toString());
//        logger.info("get message request: ");
//        Tracing.currentTracer().currentSpan().tag("gray_zone", "blue");
//        logger.info("MDC: " + MDC.get("user_env"));
//        String user_env = MySleuthFilter.concurrentHashMap.get(MDC.get("user_env"));
//        if(user_env == null) {
//            throw new RuntimeException("fail ");
//        } else {
//            MySleuthFilter.concurrentHashMap.remove(MDC.get("user_env"));
//        }
//        logger.info("concurrent count : " + MySleuthFilter.concurrentHashMap.size());

//        zipkin2.;
//        logger.info("current span: " + Tracing.currentTracer().currentSpan().context().traceIdString());
//        logger.info("extrn: " + Tracing.currentTracer().currentSpan().context().extra());
        return Mono.just("get message");

//        return Mono.just("get message");
    }

}
