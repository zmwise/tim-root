package com.tim.service.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tim.dao.sys.user.SysUserDao;
import com.tim.entity.sys.user.SysUser;
import com.tim.sys.user.SysUserDto;
import com.tim.utils.encrypt.PasswordHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    private PasswordHelper passwordHelper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public SysUser getById(Long userId) {
        return sysUserDao.selectById(userId);
    }

    @Override
    public SysUser getByUsername(String username) {
        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        List<SysUser> users = sysUserDao.selectByMap(param);
        if(users!=null && users.size()>0){
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public SysUserDto validate(String username, String password) {
        SysUserDto userDto = new SysUserDto();
        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        List<SysUser> users = sysUserDao.selectByMap(param);
        if(users!=null && users.size()>0){
            String encryptPwd = passwordHelper.encryptPassword(username,password,users.get(0).getSalt());
            if(StringUtils.equals(encryptPwd,users.get(0).getPassword())){
                BeanUtils.copyProperties(users.get(0),userDto);
            }
        }
        return userDto;
    }

    @Override
    public SysUserDto getUserInfo(String token) throws Exception {
        String username = null;
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
