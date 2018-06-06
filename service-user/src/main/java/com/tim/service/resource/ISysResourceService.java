package com.tim.service.resource;

import com.tim.entity.sys.resource.SysResource;
import com.tim.request.JwtAuthenticationRequest;

import java.util.List;

/**
 * @description:
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
public interface ISysResourceService {
    /**
     * 查询用户拥有的所有资源权限
     * @auther: lizhiming
     * @date: 2018/6/6 16:50
     */
    List<SysResource> userResource(String username);
}
