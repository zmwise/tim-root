package com.tim.service.resource;

import com.tim.dao.sys.resource.SysResourceDao;
import com.tim.entity.sys.resource.SysResource;
import com.tim.syslog.SysServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@Service
public class SysResourceServiceImpl implements ISysResourceService {
    @Autowired
    private SysResourceDao sysResourceDao;

    @Override
    @SysServiceLog(desc = "查询用户拥有的所有资源权限")
    public List<SysResource> userResource(String username) {
        return sysResourceDao.userResource(username);
    }
}
