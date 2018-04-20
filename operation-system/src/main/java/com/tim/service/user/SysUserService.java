package com.tim.service.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("service-user")
public interface SysUserService {

    @PostMapping("/getSysUser")
    String getSysUser(@RequestParam("userId") String userId);
}
