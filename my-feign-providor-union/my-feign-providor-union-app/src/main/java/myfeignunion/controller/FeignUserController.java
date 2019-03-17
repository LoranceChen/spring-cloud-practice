package myfeignunion.controller;

import myfeignunion.api.FeignAppData;
import myfeignunion.api.IFeignUnionBasic;
import myfeignunion.api.IFeignUnionUser;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController implements IFeignUnionUser {

    public FeignAppData.NameInfo getUserName() {
        FeignAppData.NameInfo feignName = new FeignAppData.NameInfo();
        feignName.name = "feign union app - name ";

        return feignName;
    }
}
