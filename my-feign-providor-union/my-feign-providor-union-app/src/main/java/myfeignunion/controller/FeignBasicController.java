package myfeignunion.controller;

import myfeignunion.api.FeignAppData;
import myfeignunion.api.IFeignUnionBasic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignBasicController implements IFeignUnionBasic {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${my-region}")
    String region;

    public FeignAppData.BasicInfo getBasicInfo() {
        logger.info("my_region: " + region);
        FeignAppData.BasicInfo feignName = new FeignAppData.BasicInfo();
        feignName.basic = "feign union app - basic info, " + region;

        return feignName;
    }
}
