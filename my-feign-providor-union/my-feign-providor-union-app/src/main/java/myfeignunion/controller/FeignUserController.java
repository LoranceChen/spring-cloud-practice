package myfeignunion.controller;

import myfeignunion.api.FeignAppData;
import myfeignunion.api.IFeignUnionBasic;
import myfeignunion.api.IFeignUnionUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController implements IFeignUnionUser {
    @Value("${my-region}")
    String region;

    public FeignAppData.NameInfo getUserName() {
        FeignAppData.NameInfo feignName = new FeignAppData.NameInfo();
        feignName.name = "feign union app - name, " + region;

        return feignName;
    }
}
