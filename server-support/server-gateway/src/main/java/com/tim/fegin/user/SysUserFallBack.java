package com.tim.fegin.user;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lizhiming
 * @date: 2018/5/30 16:21
 */
@Component
public class SysUserFallBack implements SysUserService {

    @Override
    public String getByUsername(String username) {
        return "getByUsername error";
    }

}
