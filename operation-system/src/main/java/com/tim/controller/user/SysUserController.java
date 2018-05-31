package com.tim.controller.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.tim.entity.sys.user.SysUser;
import com.tim.service.user.SysUserService;
import com.tim.sys.user.SysUserDto;
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

    @PostMapping("/add")
    @ResponseBody
    public Boolean add(@RequestBody SysUser user) {
        System.out.println("--------------add----------------->");
        System.out.println(JSON.toJSON(user));
        sysUserService.add(JSON.toJSONString(user));
        return null;
    }

    @PostMapping("/list/{pageSize}/{pageNo}")
    public String list(@PathVariable("pageSize") int pageSize,
                       @PathVariable("pageNo") int pageNo,
                       @RequestBody(required = false) SysUserDto sysUserDto){
        Page<SysUser> sus = sysUserService.list(pageSize,pageNo,JSON.toJSONString(sysUserDto));
        return JSON.toJSONString(sus);
    }
}
