package sidecarapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SidecarCtrl {
//    public static class Host {
//        public String host;
//        public Integer port;
//        public String uri;
//        public String serviceId;
//        public Boolean secure;
//    }
//
////    /hosts/{serviceId}
//    @GetMapping("/hosts/sidecar.app")
//    public List<Host> hosts() {
//
//        List<Host> hosts = new List<>();
//        Host host = new Host();
//        host.host = "localhost";
//        host.port = 3201;
//        host.secure = false;
//        host.serviceId = "sidecar.app";
//        host.uri = "http://localhost:3201";
//
//        hosts.add(host);
//    }


    @GetMapping("/health.json")
    public String health() {
        return "{\n" +
                "  \"status\":\"UP\"\n" +
                "}";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }
}
