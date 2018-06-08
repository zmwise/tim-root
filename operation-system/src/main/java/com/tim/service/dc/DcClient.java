package com.tim.service.dc;

import com.tim.config.fegin.FeignSimpleEncoderConfig;
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
@FeignClient(name = "service-user",configuration = FeignSimpleEncoderConfig.class)
public interface DcClient {

    @GetMapping("/consumer")
    String consumer();

}
