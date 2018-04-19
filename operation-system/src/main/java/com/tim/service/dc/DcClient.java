package com.tim.service.dc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 注意有两个坑:
 * 1. @GetMapping不支持
 * 2. @PathVariable得设置value
 * 3. 只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求
 *
 */
//@FeignClient(name = "service-user", fallback = DcClientFallback.class)
@FeignClient("service-user")
public interface DcClient {

    //    @RequestMapping(method = RequestMethod.GET, value = "/dc")
    @GetMapping("/dc")
    String consumer();

    @GetMapping("/getUser")
    String getUser(Long id);

}
