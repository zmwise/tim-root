package com.tim.fegin.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.tim.config.fegin.FeignMultipartSupportConfig;
import com.tim.entity.sys.resource.SysResource;
import com.tim.entity.sys.user.SysUser;
import com.tim.sys.user.SysUserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "service-user",fallback=SysUserFallBack.class,configuration = FeignMultipartSupportConfig.class)
public interface SysUserService {

    @PostMapping("/sysUser/getById")
    String getById(@RequestParam("userId") String userId);

    @PostMapping("/sysUser/add")
    Boolean add(@RequestParam("user") String user);

    @PostMapping("/sysUser/list/{pageSize}/{pageNo}")
    Page<SysUser> list(@PathVariable("pageSize") int pageSize,
                       @PathVariable("pageNo") int pageNo,
                       @RequestBody(required = false) String sysUserDto);

    @RequestMapping(value = "/sysUser/info", method = RequestMethod.POST)
    SysUserDto getUserInfo(@RequestParam("token") String token);

    @RequestMapping(value = "/res/get", method = RequestMethod.POST)
    List<SysResource> userResource(@RequestParam("username") String username);

}
