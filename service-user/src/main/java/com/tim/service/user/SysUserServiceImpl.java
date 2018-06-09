package com.tim.service.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tim.common.jwt.JWTInfo;
import com.tim.config.auth.UserAuthUtil;
import com.tim.dao.sys.user.SysUserDao;
import com.tim.entity.sys.user.SysUser;
import com.tim.exception.auth.UserInvalidException;
import com.tim.sys.user.SysUserDto;
import com.tim.utils.jwt.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lizhiming
 * @create: 2018/4/20 15:30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private UserAuthUtil userAuthUtil;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public SysUser getById(Long userId) {
        return sysUserDao.selectById(userId);
    }

    @Override
    public String getToken(String username, String password) throws Exception {
        SysUserDto info = this.validate(username,password);
        if (!StringUtils.isEmpty(info.getId())) {
            return jwtTokenUtil.generateToken(new JWTInfo(info.getUsername(), info.getId() + "", info.getRealName()));
        }
        throw new UserInvalidException("用户不存在或账户密码错误!");
    }

    @Override
    public SysUserDto validate(String username, String password) {
        SysUserDto userDto = new SysUserDto();
        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        List<SysUser> users = sysUserDao.selectByMap(param);
        if(users!=null && users.size()>0){
            if(encoder.matches(password,users.get(0).getPassword())){
                BeanUtils.copyProperties(users.get(0),userDto);
            }
        }
        return userDto;
    }

    @Override
    public SysUserDto getUserInfo(String token) throws Exception {
        String username = userAuthUtil.getInfoFromToken(token).getUniqueName();
        if (username == null) {
            return null;
        }
        SysUserDto userDto = new SysUserDto();
        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        List<SysUser> users = sysUserDao.selectByMap(param);
        if(users!=null && users.size()>0){
            BeanUtils.copyProperties(users.get(0),userDto);
        }
        return userDto;
    }
}
