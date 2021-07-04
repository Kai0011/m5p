package com.data.m5p.service;

import com.data.m5p.mapper.UserMapper;
import com.data.m5p.mapper.UserTokenMapper;
import com.data.m5p.pojo.User;
import com.data.m5p.pojo.UserToken;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import xyz.erupt.annotation.config.Comment;
import xyz.erupt.upms.model.EruptUser;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

@Service
public class LoginService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserTokenMapper userTokenMapper;

    public String login(String account, String pwd) throws Exception {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("account", account);
        User user = userMapper.selectOneByExample(example);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception ignored) {}
        if (user.getLoginPsw().equals(pwd)) {
            String uuid = UUID.randomUUID().toString();
            UserToken userToken = userTokenMapper.selectByPrimaryKey(user.getId());
            userToken.setToken(uuid);
            userToken.setExpire(new Date());
            userTokenMapper.updateByPrimaryKeySelective(userToken);
            return uuid;
        }
        throw new Exception("登录失败");
    }

    public boolean verify(String token) throws Exception {
        if (token == null || token.length() == 0) {
            return false;
        }
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("token", token);
        User user = userMapper.selectOneByExample(example);
        return user != null;
    }

    @Comment("注销事件")
    public void logout(String token) {
    }

    @Comment("修改密码")
    public void beforeChangePwd(EruptUser eruptUser, String newPwd) {
    }
}