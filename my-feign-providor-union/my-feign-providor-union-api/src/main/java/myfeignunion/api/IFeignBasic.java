package myfeignunion.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("myfeignunion.app")
public interface IFeignBasic {

    @RequestMapping(method = RequestMethod.POST,
            value = "/feign-union-name")
    FeignAppData.FeignName getFeignUnionName();

}
