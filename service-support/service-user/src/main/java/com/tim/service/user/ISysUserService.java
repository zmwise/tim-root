package com.tim.service.user;

import com.baomidou.mybatisplus.service.IService;
import com.tim.entity.sys.user.SysUser;
import com.tim.sys.user.SysUserDto;

/**
 * @description:
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 根据id查询系统用户信息
     * @param userId
     * @return
     */
    SysUser getById(Long userId);

    SysUser getByUsername(String username);

    SysUserDto validate(String username,String password);

    SysUserDto getUserInfo(String token) throws Exception;

    String getToken(String username, String password) throws Exception;
}
