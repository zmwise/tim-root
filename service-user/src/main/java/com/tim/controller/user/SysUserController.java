package com.tim.controller.user;

import com.tim.entity.sys.user.SysUser;
import com.tim.service.user.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/getSysUser")
    public String getSysUser(String userId){
        SysUser user = sysUserService.getSysUserById(Long.valueOf(userId));
        return user.toString();
    }
}
