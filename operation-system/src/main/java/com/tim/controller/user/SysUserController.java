package com.tim.controller.user;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.tim.entity.sys.resource.SysResource;
import com.tim.entity.sys.user.SysUser;
import com.tim.request.JwtAuthenticationRequest;
import com.tim.result.Result;
import com.tim.result.ResultFactory;
import com.tim.result.Status;
import com.tim.service.user.SysUserService;
import com.tim.sys.user.SysUserDto;
import com.tim.syslog.SysControllerLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sysUser")
@Slf4j
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

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserInfo(String token) throws Exception {
        SysUserDto userInfo = sysUserService.getUserInfo(token);
        if(userInfo==null) {
            return ResultFactory.result(Status.UNAUTHORIZED,Status.UNAUTHORIZED_MSG);
        } else {
            return ResultFactory.successData(userInfo);
        }
    }

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public Result createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws Exception {
        log.info(authenticationRequest.getUsername()+" require logging...");
        String token = sysUserService.getToken(authenticationRequest);
        return ResultFactory.successData(token);
    }

    @SysControllerLog(desc = "查询用户拥有的所有资源权限")
    @RequestMapping(value = "res", method = RequestMethod.POST)
    public Result userResource(String username) {
        List<SysResource> ress = sysUserService.userResource(username);
        return ResultFactory.successData(ress);
    }
}
