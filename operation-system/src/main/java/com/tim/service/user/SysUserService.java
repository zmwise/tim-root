package com.tim.service.user;

import com.tim.entity.sys.user.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "service-user")
public interface SysUserService {

    @GetMapping("/getSysUser")
    SysUser getSysUser(Long userId);
}
