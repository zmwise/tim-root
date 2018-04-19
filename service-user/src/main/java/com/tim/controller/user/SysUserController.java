package com.tim.controller.user;

import com.tim.entity.sys.user.SysUser;
import com.tim.service.user.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/getSysUser")
    public String getSysUser(Long userId){
        SysUser user = sysUserService.getSysUserById(userId);
        return user.toString();
    }
}
