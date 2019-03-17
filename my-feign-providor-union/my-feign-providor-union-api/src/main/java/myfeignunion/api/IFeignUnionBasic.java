package myfeignunion.api;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("myfeignunion.app")
public interface IFeignUnionBasic {

    @RequestMapping(method = RequestMethod.POST,
            value = "/feign-union-basic-info")
    FeignAppData.BasicInfo getBasicInfo();

}