package com.tim.service.user;

import com.alibaba.fastjson.JSON;
import com.tim.fegin.user.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @description: 用户信息服务
 *  实现 Spring Security的UserDetailsService接口方法，用于身份认证
 * @author: lizhiming
 * @date: 2018/7/17 15:59
 */
@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据用户名查找账户信息并返回用户信息实体
     * @param username 用户名
     * @return 用于身份认证的 UserDetails 用户信息实体
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String account = sysUserService.getByUsername(username);
        if (account!=null && StringUtils.isNotBlank(account)){
            SysUser user = JSON.parseObject(account,SysUser.class);
            return new User(user.getUsername(),user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoleIds()));
        }else {
            throw  new UsernameNotFoundException("用户["+username+"]不存在");
        }
    }
}
