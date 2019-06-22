package mywebflux.config;

import brave.Tracing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@Component
public class ExampleHandlerFilterFunction
        implements HandlerFilterFunction<ServerResponse, ServerResponse> {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Mono<ServerResponse> filter(ServerRequest serverRequest,
                                       HandlerFunction<ServerResponse> handlerFunction) {

        logger.info("current span ExampleHandlerFilterFunction: ");
        logger.info("current span Tracing: " + Tracing.currentTracer().currentSpan().context().traceIdString());

        if (serverRequest.pathVariable("name").equalsIgnoreCase("test")) {
            return ServerResponse.status(FORBIDDEN).build();
        }
        return handlerFunction.handle(serverRequest);
    }
}