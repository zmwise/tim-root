package com.tim.service.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.tim.entity.sys.user.SysUser;
import com.tim.sys.user.SysUserDto;
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
    public Boolean add(String user) {
        return false;
    }

    @Override
    public Page<SysUser> list(int pageSize, int pageNo, String sysUserDto) {
        return null;
    }

}
