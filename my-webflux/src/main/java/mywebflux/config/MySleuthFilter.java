package mywebflux.config;

import brave.Span;
import brave.SpanCustomizer;
import brave.Tracer;
import brave.Tracing;
import brave.propagation.ExtraFieldPropagation;
import brave.propagation.TraceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.web.TraceHttpAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.web.TraceWebFilter;
import org.springframework.cloud.sleuth.instrument.web.TraceWebFluxAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.cloud.sleuth.instrument.web.client.TraceWebAsyncClientAutoConfiguration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

//@Order(TraceWebFluxAutoConfiguration.TRACING_FILTER_ORDER + 1)
@Component
@Order(Ordered.HIGHEST_PRECEDENCE+1)
public class MySleuthFilter implements WebFilter, Ordered{
    Logger logger = LoggerFactory.getLogger(getClass());
//TraceWebFilter
    @Autowired
    Tracer tracer;

//    public static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        tracer.startScopedSpan("hello");
//        span.tag("gray_header", "blue");
//        logger.info("hello - ");

        String v = "gray_" + new Random().nextInt(2);
        logger.info("gray_" + new Random().nextInt(2));
        MDC.put("user_env" , v);
//        concurrentHashMap.put(v, "1");
//        logger.info("nextSpan: " + tracer.nextSpan().context().traceIdString());
//        logger.info("current span: " + tracer
//                .currentSpan()
//                .context()
//                .traceIdString());
//        ExtraFieldPropagation.
//        return chain.filter(exchange);
        Mono<Void> filter = chain.filter(exchange);
//        logger.info("current span: " + tracer.currentSpan().context().traceIdString());
//        logger.info("hello - ");
//        tracer.currentSpan().tag("gray_header", "blue");

//        exchange.getResponse()
//                .getHeaders().add("web-filter", "web-filter-test");

//        filter.doOnSubscribe((x) -> {
//            logger.info("current span222: " + Tracing.currentTracer().currentSpan().context().traceIdString());
//
//        });
//        filter.subscribe();

        return filter;
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
