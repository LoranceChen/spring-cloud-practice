package myfeignunion.controller;

import myfeignunion.api.FeignAppData;
import myfeignunion.api.IFeignUnionBasic;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignBasicController implements IFeignUnionBasic {

    public FeignAppData.BasicInfo getBasicInfo() {
        FeignAppData.BasicInfo feignName = new FeignAppData.BasicInfo();
        feignName.basic = "feign union app - basic info ";

        return feignName;
    }
}
