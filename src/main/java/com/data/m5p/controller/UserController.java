package com.data.m5p.controller;

import com.data.m5p.common.CommonResult;
import com.data.m5p.pojo.User;
import com.data.m5p.service.UserService;
import com.data.m5p.vo.UserVO;
import io.swagger.annotations.Api;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@Api(tags = "首页模块")
@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/users")
    public CommonResult<String> createUser(@RequestBody User user) throws Exception {

        userService.createUser(user);

        return CommonResult.success("create user successfully");
    }

    @GetMapping("/users/{id}")
    public CommonResult<UserVO> getUser(@PathVariable BigInteger id) throws NotFoundException {

        User user = userService.getUserById(id);
        UserVO userVO = UserService.UserToUserVO(user);

        return CommonResult.success(userVO);
    }
}