package myfeignconsumer.controller;

import myfeignunion.api.FeignUnionBean;
import myfeignunion.api.IFeignBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFeginConsumerController {

    @Autowired
    FeignUnionBean feignUnionBean;

    @Autowired
    IFeignBasic feignBasic;

    @PostMapping("/consumer-provider-info")
    public String consumerProviderInfo() {
        return "consumer: " + feignUnionBean.getNmame() + ", " + feignBasic.getFeignUnionName().name;
    }

}
