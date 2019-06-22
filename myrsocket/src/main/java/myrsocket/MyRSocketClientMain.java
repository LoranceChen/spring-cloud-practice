package myrsocket;

import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.client.TcpClientTransport;
import org.HdrHistogram.Recorder;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class MyRSocketClientMain {
   public static void main(String... args) throws InterruptedException {
       Mono<RSocket> client =
               RSocketFactory.connect()
                       .frameDecoder(PayloadDecoder.ZERO_COPY)
                       .transport(TcpClientTransport.create(2000))
                       .start();

       PingClient pingClient = new PingClient(client);

       Recorder recorder = pingClient.startTracker(Duration.ofSeconds(1));

       int count = 1_000;

       pingClient
               .requestResponsePingPong(count, recorder)
               .doOnTerminate(() -> System.out.println("Sent " + count + " messages."))
               .blockLast();

       Thread.currentThread().join();
   }
}
