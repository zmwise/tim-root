package com.tim.fegin.user;

import com.baomidou.mybatisplus.plugins.Page;
import com.tim.entity.sys.resource.SysResource;
import com.tim.entity.sys.user.SysUser;
import com.tim.fegin.user.SysUserService;
import com.tim.request.JwtAuthenticationRequest;
import com.tim.sys.user.SysUserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @Override
    public SysUserDto getUserInfo(String token) {
        return null;
    }

    @Override
    public String getToken(JwtAuthenticationRequest authenticationRequest) {
        return null;
    }

    @Override
    public List<SysResource> userResource(String username) {
        return null;
    }

}
