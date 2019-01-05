package myconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PickPortConfig
        implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Value("${server.custom_port}")
    String customPortRange;

    public void customize(ConfigurableWebServerFactory factory) {
        System.out.println("customPortRange - " + customPortRange);
        String[] split = customPortRange.split("-");
        int availablePort = getAvailablePort(Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toList()));
        factory.setPort(availablePort);
    }

    private int getAvailablePort(List<Integer> portRange) {
        if(portRange.size() == 1){
            return portRange.get(0);
        }
        return SocketUtils.findAvailableTcpPort(portRange.get(0), portRange.get(1));
    }
}