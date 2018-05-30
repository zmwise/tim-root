package com.tim.controller.user;

import com.alibaba.fastjson.JSON;
import com.tim.entity.sys.user.SysUser;
import com.tim.service.user.ISysUserService;
import com.tim.syslog.SysControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 系统用户控制器
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * @auther: lizhiming
     * @date: 2018/4/20 16:03
     */
    @PostMapping("/getById")
    @SysControllerLog(desc = "根据ID获取系统用户")
    public String getById(String userId){
        SysUser user = sysUserService.getById(Long.valueOf(userId));
        return JSON.toJSONString(user);
    }

    /**
     * @auther: lizhiming
     * @date: 2018/4/20 16:03
     */
    @RequestMapping(name = "/add", method = RequestMethod.POST)
    @SysControllerLog(desc = "添加系统用户")
    public Boolean add(@RequestBody SysUser user){
        System.out.println("++++++++++++++++++++++++++++++++>");
        System.out.println(JSON.toJSON(user));
        return sysUserService.insert(user);
    }
}
