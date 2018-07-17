package com.tim.fegin.user;

import com.tim.config.fegin.FeignMultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "service-user",fallback=SysUserFallBack.class,configuration = FeignMultipartSupportConfig.class)
public interface SysUserService {

    @PostMapping("/sysUser/getByUsername")
    String getByUsername(@RequestParam("username") String username);

}
