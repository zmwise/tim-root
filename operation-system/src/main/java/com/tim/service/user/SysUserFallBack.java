package com.tim.service.user;

import com.tim.entity.sys.user.SysUser;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/5/30 16:21
 */
@Component
public class SysUserFallBack implements SysUserService {

    @Override
    public String getById(String userId) {
        return "getById error";
    }

    @Override
    public Boolean add(SysUser user) {
        return false;
    }
}
