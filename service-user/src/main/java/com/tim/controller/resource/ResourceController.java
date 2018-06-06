package com.tim.controller.resource;

import com.tim.entity.sys.resource.SysResource;
import com.tim.service.resource.ISysResourceService;
import com.tim.syslog.SysControllerLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/6/1 19:38
 */
@RestController
@RequestMapping("res")
@Slf4j
public class ResourceController {

    @Autowired
    private ISysResourceService sysResourceService;

    @SysControllerLog(desc = "查询用户拥有的所有资源权限")
    @RequestMapping(value = "get", method = RequestMethod.POST)
    @ResponseBody
    public List<SysResource> userResource(@RequestParam String username) {
        List<SysResource> ress = sysResourceService.userResource(username);
        return ress;
    }
}
