package com.data.m5p.service;

import com.data.m5p.mapper.UserMapper;
import com.data.m5p.pojo.User;
import com.data.m5p.vo.UserVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Date;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void createUser (@RequestBody User user) throws Exception{
        user.setUserType(1);
        user.setStatus(1);
        user.setCreateDate(new Date());
        user.setModifiedDate(new Date());
        userMapper.insert(user);

        System.out.println(user.getId());
        System.out.println(user.getLoginName());
        System.out.println(user.getLoginPsw());
    }

    public User getUserById(BigInteger id) throws NotFoundException {
        User user = userMapper.selectByPrimaryKey(id);
        if(user==null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    public static UserVO UserToUserVO(User user){
        UserVO userVO = new UserVO();
        userVO.setDisplayName(user.getDisplayName());
        userVO.setGender(user.getGender());
        return userVO;
    }
}
