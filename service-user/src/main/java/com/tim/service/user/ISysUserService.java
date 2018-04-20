package com.tim.service.user;

import com.baomidou.mybatisplus.service.IService;
import com.tim.entity.sys.user.SysUser;

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
}
