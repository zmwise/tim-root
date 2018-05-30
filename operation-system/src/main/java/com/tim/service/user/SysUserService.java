package com.tim.service.user;

import com.tim.config.redis.fegin.FeignMultipartSupportConfig;
import com.tim.entity.sys.user.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "service-user",fallback=SysUserFallBack.class,configuration = FeignMultipartSupportConfig.class)
public interface SysUserService {

    @PostMapping("/sysUser/getById")
    String getById(@RequestParam("userId") String userId);

    @RequestMapping(value = "/sysUser/add",method = RequestMethod.POST)
    Boolean add(@RequestBody SysUser user);
}
