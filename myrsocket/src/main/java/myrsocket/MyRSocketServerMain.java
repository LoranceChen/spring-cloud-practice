package myrsocket;

import io.rsocket.RSocketFactory;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;

public class MyRSocketServerMain {
    public static void main(String... args) {
        RSocketFactory.receive()
                // Enable Zero Copy
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .acceptor(new PingHandler())
                .transport(TcpServerTransport.create(7878))
                .start()
                .block()
                .onClose()
                .block();
    }

}
