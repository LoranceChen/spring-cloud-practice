package orderserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@Component
public class PickPortConfig
        implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Value("${server.custom_port}")
    String customPortRange;

    // todo：use a ensure Server Property init hook to reset server.port
    public void customize(ConfigurableWebServerFactory factory) {
        System.out.println("customPortRange - " + customPortRange);
        String[] split = customPortRange.split("-");
        Integer availablePort = getAvailablePort(Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList()));
        System.setProperty("server.port", String.valueOf(availablePort));

        factory.setPort(availablePort);
    }

    private int getAvailablePort(List<Integer> portRange) {
        if(portRange.size() == 1){
            return portRange.get(0);
        }
        return SocketUtils.findAvailableTcpPort(portRange.get(0), portRange.get(1));
    }

}