package com.data.m5p.service;

import com.data.m5p.common.IdWorker;
import com.data.m5p.idworker.DatacenterId;
import com.data.m5p.mapper.UserMapper;
import com.data.m5p.mapper.UserTokenMapper;
import com.data.m5p.pojo.User;
import com.data.m5p.pojo.UserToken;
import com.data.m5p.vo.UserVO;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserTokenMapper userTokenMapper;

    private IdWorker idWorker = new IdWorker(1, DatacenterId.User.getValue(), 1);

    public void createUser (User user) {

        user.setId(idWorker.nextId());
        user.setUserType(1);
        user.setStatus(1);
        user.setCreateDate(new Date());
        user.setModifiedDate(new Date());
        userMapper.insert(user);

        System.out.println(user.getLoginName());
    }

    public User getUserById(Long id) throws NotFoundException {
        User user = userMapper.selectByPrimaryKey(id);
        if(user==null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    public void updateUser(User user) {

        user.setModifiedDate(new Date());
        userMapper.updateByPrimaryKeySelective(user);

    }

    public void deleteUser(Long id) {

        User user = this.existUser(id);
        if (user!=null){
            user.setStatus(0);
        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    public User existUser(Long id) {
        if (userMapper.existsWithPrimaryKey(id)) {
            User user = userMapper.selectByPrimaryKey(id);
            if (user.getStatus()==1){
                return user;
            }
            return null;
        }
        return null;
    }

    public static UserVO UserToUserVO(User user){
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setDisplayName(user.getDisplayName());
        userVO.setGender(user.getGender());
        userVO.setIcon(user.getIcon());
        userVO.setRealName(user.getRealName());
        return userVO;
    }

    public Long getIdByToken(String token) {
        Example userTokenExample = new Example(UserTokenMapper.class);
        Example.Criteria userTokenCriteria = userTokenExample.createCriteria();
        userTokenCriteria.andEqualTo("token", token);

        UserToken userToken = userTokenMapper.selectOneByExample(userTokenExample);

        return  userToken.getUserId();
    }
}
