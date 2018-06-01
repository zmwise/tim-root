package com.tim.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.tim.config.fegin.FeignSimpleEncoderConfig;
import com.tim.entity.sys.user.SysUser;
import com.tim.sys.user.SysUserDto;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "service-user",fallback=SysUserFallBack.class,configuration = FeignSimpleEncoderConfig.class)
public interface SysUserService {

    @PostMapping("/sysUser/getById")
    String getById(@RequestParam("userId") String userId);

    @PostMapping("/sysUser/add")
    Boolean add(@RequestParam("user") String user);

    @PostMapping("/sysUser/list/{pageSize}/{pageNo}")
    Page<SysUser> list(@PathVariable("pageSize") int pageSize,
                       @PathVariable("pageNo") int pageNo,
                       @RequestBody(required = false) String sysUserDto);
}