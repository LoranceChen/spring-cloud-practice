package myfeignconsumer.controller;

import myfeignunion.api.FeignUnionBean;
//import myfeignunion.api.IFeignUnionApis;
import myfeignunion.api.IFeignUnionBasic;
import myfeignunion.api.IFeignUnionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFeginConsumerController {

    @Autowired
    FeignUnionBean feignUnionBean;

    @Autowired
    IFeignUnionUser feignUnionUser;

    @Autowired
    IFeignUnionBasic feignUnionBasic;

    @PostMapping("/consumer-provider-info")
    public String consumerProviderInfo() {
        return "consumer: " + feignUnionBean.getNmame() +
                ", " + feignUnionBasic.getBasicInfo().basic +
                ", " + feignUnionUser.getUserName().name;
    }

}
