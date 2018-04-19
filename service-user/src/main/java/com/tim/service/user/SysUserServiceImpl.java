package com.tim.service.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tim.dao.sys.user.SysUserDao;
import com.tim.entity.sys.user.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser getSysUserById(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
