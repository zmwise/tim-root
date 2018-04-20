package com.tim.controller.user;

import com.tim.service.user.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/getById")
    @ResponseBody
    public String getById(String userId) {
        String user = sysUserService.getById(userId);
        return user;
    }
}
