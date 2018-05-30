package com.tim.service.user;

import com.tim.entity.sys.user.SysUser;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "service-user",fallback=SysUserFallBack.class)
public interface SysUserService {

    @PostMapping("/sysUser/getById")
    String getById(@RequestParam("userId") String userId);

    @RequestMapping(value = "/sysUser/add",method = RequestMethod.POST)
    @Headers("Content-Type: application/json")
    Boolean add(SysUser user);
}
