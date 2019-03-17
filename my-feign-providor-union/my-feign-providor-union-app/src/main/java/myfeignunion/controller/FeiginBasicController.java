package myfeignunion.controller;

import myfeignunion.api.FeignAppData;
import myfeignunion.api.IFeignBasic;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeiginBasicController implements IFeignBasic {

    public FeignAppData.FeignName getFeignUnionName() {
        FeignAppData.FeignName feignName = new FeignAppData.FeignName();
        feignName.name = "feign union app";

        return feignName;
    }
}
