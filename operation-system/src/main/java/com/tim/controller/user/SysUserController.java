package com.tim.controller.user;

import com.tim.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SysUserController {
    /*@Autowired
    private SysUserService sysUserService;

    @GetMapping("/getSysUser")
    @ResponseBody
    public String getSysUser(String userId) {
        String user = sysUserService.getSysUser(userId);
        return user;
    }*/
}
