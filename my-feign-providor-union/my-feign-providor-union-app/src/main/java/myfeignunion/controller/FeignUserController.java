package myfeignunion.controller;

import myfeignunion.api.FeignAppData;
import myfeignunion.api.IFeignUnionBasic;
import myfeignunion.api.IFeignUnionUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController implements IFeignUnionUser {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${my-region}")
    String region;

    public FeignAppData.NameInfo getUserName() {
        logger.info("my_region: " + region);

        FeignAppData.NameInfo feignName = new FeignAppData.NameInfo();
        feignName.name = "feign union app - name, " + region;

        return feignName;
    }
}
