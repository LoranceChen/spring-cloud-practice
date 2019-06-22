package myfeignconsumer.feign.user;

import myfeignunion.api.IFeignUnionBasic;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "myfeignunion.app", path = "")
public interface UserBasicApi extends IFeignUnionBasic {
}
