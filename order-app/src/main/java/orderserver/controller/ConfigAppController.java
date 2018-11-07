package orderserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigAppController {

    @Value("${myname}")
    String myname;

    @GetMapping("/myname")
    public String from() {
        return this.myname;

    }
}
