package com.tim.service.auth;

import com.tim.common.jwt.JWTInfo;
import com.tim.exception.auth.UserInvalidException;
import com.tim.request.JwtAuthenticationRequest;
import com.tim.service.user.ISysUserService;
import com.tim.sys.user.SysUserDto;
import com.tim.utils.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @description:
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@Service
public class AuthServiceImpl implements IAuthService{
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private ISysUserService sysUserService;
    @Override
    public String login(JwtAuthenticationRequest authenticationRequest) throws Exception {
        SysUserDto userDto = sysUserService.validate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        if (!StringUtils.isEmpty(userDto.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(userDto.getUsername(), userDto.getId() + "", userDto.getRealName()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }
}
