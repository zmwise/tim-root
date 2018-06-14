package com.tim.utils.encrypt;

import com.tim.entity.sys.user.SysUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * 密码工具类
 * 
 * @author zhanghaitao
 *
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";
    
    private int hashIterations = 2;

    public void setRandomNumberGenerator(
            RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(SysUser user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(algorithmName, user.getPassword(),
                ByteSource.Util.bytes(user.getUsername() + user.getSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }

    public String encryptPassword(String username,String password,String salt){
        return new SimpleHash(algorithmName, password,
                ByteSource.Util.bytes(username + salt),
                hashIterations).toHex();
    }

    public static void main(String[] args) {
        String newPassword = new SimpleHash("md5", "Qhfax@123",
                ByteSource.Util.bytes("lizhiming" + "0a0396c96ff6f83c2cf49c56e81b6941"),
                2).toHex();
        System.out.println(newPassword);
    }
}
